package net.sam.dcl.modern;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class ParitySmokeTests {

    private static final int INITIAL_SCREEN_LIMIT = 10;
    private static final Path PARITY_DIR = Path.of("..", "docs", "parity");
    private static final Path REPORT_PATH = Path.of("src/test/resources/reports/parity-smoke-latest.md");

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16")
            .withDatabaseName("dcl")
            .withUsername("dcl")
            .withPassword("dcl");

    private static final List<ScreenResult> RESULTS = new ArrayList<>();

    @DynamicPropertySource
    static void props(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.flyway.enabled", () -> "true");
    }

    @Autowired
    MockMvc mvc;

    @Autowired
    TestDataFactory testDataFactory;

    @BeforeEach
    void seed() {
        testDataFactory.cleanupAll();
        testDataFactory.seedCoreData();
    }

    @TestFactory
    Stream<DynamicTest> paritySmokeScreens() throws IOException {
        List<ParityScreenSpec> specs = loadSpecs();
        return specs.stream().map(spec -> DynamicTest.dynamicTest(spec.slug(), () -> runScreenSmoke(spec)));
    }

    @AfterAll
    static void writeReport() throws IOException {
        Files.createDirectories(REPORT_PATH.getParent());
        long passed = RESULTS.stream().filter(ScreenResult::passed).count();
        List<String> lines = new ArrayList<>();
        lines.add("# Parity Smoke Report");
        lines.add("");
        lines.add("- Date: " + LocalDate.now());
        lines.add("- Coverage: " + passed + "/" + RESULTS.size() + " passed");
        lines.add("");
        lines.add("| Screen | GET path | GET | POST | Status | Notes |");
        lines.add("|---|---|---:|---:|---|---|");
        for (ScreenResult result : RESULTS) {
            lines.add("| " + result.slug + " | `" + result.path + "` | " + result.getStatus + " | " + result.postStatus + " | " + (result.passed ? "PASS" : "FAIL") + " | " + result.note + " |");
        }
        Files.writeString(REPORT_PATH, String.join(System.lineSeparator(), lines) + System.lineSeparator());
    }

    private void runScreenSmoke(ParityScreenSpec spec) throws Exception {
        MvcResult getResult = mvc.perform(get(spec.path())).andReturn();
        int getStatus = getResult.getResponse().getStatus();

        MvcResult postResult = mvc.perform(post(spec.path())
                        .param("id", "SMOKE-ID")
                        .param("action", "save")
                        .param("payload", "smoke"))
                .andReturn();
        int postStatus = postResult.getResponse().getStatus();

        String note = "ok";
        boolean hasKeyFields = false;
        if (getResult.getModelAndView() != null && getResult.getModelAndView().getModel() != null) {
            Object dto = getResult.getModelAndView().getModel().get("dto");
            hasKeyFields = matchesKeyFields(dto, spec.keyFields()) || spec.keyFields().isEmpty();
            if (!hasKeyFields) {
                hasKeyFields = spec.keyFields().stream().anyMatch(k -> getResult.getModelAndView().getModel().containsKey(k));
            }
        }

        boolean passed = getStatus == 200 && (postStatus == 200 || postStatus == 302 || postStatus == 303 || postStatus == 405) && hasKeyFields;
        final String noteFinal = passed ? note : ("get=" + getStatus + ", post=" + postStatus + ", keyFields=" + hasKeyFields);

        RESULTS.add(new ScreenResult(spec.slug(), spec.path(), getStatus, postStatus, passed, noteFinal));
        assertTrue(passed, () -> "Smoke failed for " + spec.slug() + " :: " + noteFinal);
    }

    private boolean matchesKeyFields(Object dto, List<String> keyFields) {
        if (dto == null || keyFields.isEmpty()) {
            return false;
        }
        BeanWrapper wrapper = new BeanWrapperImpl(dto);
        return keyFields.stream().anyMatch(wrapper::isReadableProperty);
    }

    private List<ParityScreenSpec> loadSpecs() throws IOException {
        try (Stream<Path> files = Files.list(PARITY_DIR)) {
            return files
                    .filter(path -> path.getFileName().toString().endsWith(".md"))
                    .filter(path -> !path.getFileName().toString().equalsIgnoreCase("README.md"))
                    .sorted(Comparator.comparing(path -> path.getFileName().toString()))
                    .limit(INITIAL_SCREEN_LIMIT)
                    .map(this::toSpec)
                    .collect(Collectors.toList());
        }
    }

    private ParityScreenSpec toSpec(Path mdFile) {
        try {
            String content = Files.readString(mdFile);
            String slug = mdFile.getFileName().toString().replace(".md", "");
            String path = extractPath(content).orElse("/" + slug);
            List<String> keyFields = extractKeyFields(content);
            return new ParityScreenSpec(slug, normalizePath(path), keyFields);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read parity file: " + mdFile, e);
        }
    }

    private java.util.Optional<String> extractPath(String markdown) {
        Matcher matcher = Pattern.compile("`(/[^`\\s]+)`").matcher(markdown);
        if (matcher.find()) {
            return java.util.Optional.of(matcher.group(1));
        }
        matcher = Pattern.compile("(?m)^- Legacy URL:\\s*`?(/[^`\\s]+)").matcher(markdown);
        if (matcher.find()) {
            return java.util.Optional.of(matcher.group(1));
        }
        return java.util.Optional.empty();
    }

    private List<String> extractKeyFields(String markdown) {
        Set<String> keys = new LinkedHashSet<>();
        Matcher matcher = Pattern.compile("(?m)^\\|[^|]+\\|\\s*([^|]+?)\\s*\\|").matcher(markdown);
        while (matcher.find() && keys.size() < 6) {
            String candidate = matcher.group(1)
                    .replace("`", "")
                    .replace("*", "")
                    .trim();
            if (candidate.equalsIgnoreCase("New DTO/Entity") || candidate.isEmpty() || candidate.equals("----------------")) {
                continue;
            }
            String normalized = candidate.split("\\s+")[0]
                    .replaceAll("[^a-zA-Z0-9_\\.]", "")
                    .toLowerCase(Locale.ROOT);
            if (!normalized.isBlank()) {
                if (normalized.contains(".")) {
                    normalized = normalized.substring(normalized.lastIndexOf('.') + 1);
                }
                keys.add(normalized);
            }
        }
        return new ArrayList<>(keys);
    }

    private String normalizePath(String raw) {
        String path = raw.trim();
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        int idx = path.indexOf('?');
        if (idx > 0) {
            path = path.substring(0, idx);
        }
        return path;
    }

    private record ParityScreenSpec(String slug, String path, List<String> keyFields) {
    }

    private record ScreenResult(String slug, String path, int getStatus, int postStatus, boolean passed, String note) {
    }
}
