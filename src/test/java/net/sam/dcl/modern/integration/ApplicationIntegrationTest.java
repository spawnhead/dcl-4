package net.sam.dcl.modern.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationIntegrationTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16")
            .withDatabaseName("dcl")
            .withUsername("dcl")
            .withPassword("dcl");

    @DynamicPropertySource
    static void props(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.flyway.enabled", () -> "true");
    }

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void commercialProposalE2E_postPersistsAndMatchesLegacyEquivalentFilter() {
        String proposalNumber = "CPR-E2E-001";

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("id", proposalNumber);
        form.add("action", "save");
        form.add("payload", "integration-payload");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResponseEntity<String> response = restTemplate.postForEntity(
                "/commercial-proposal",
                new HttpEntity<>(form, headers),
                String.class
        );

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("Saved"));

        Integer rows = jdbcTemplate.queryForObject(
                "select count(*) from dcl_commercial_proposal where cpr_number = ?",
                Integer.class,
                proposalNumber
        );
        assertNotNull(rows);
        assertTrue(rows > 0);

        List<Map<String, Object>> procRows = jdbcTemplate.queryForList(
                "select * from dcl_commercial_proposal_filter(?, null, null, null)",
                proposalNumber
        );
        assertFalse(procRows.isEmpty());

        Map<String, Object> direct = jdbcTemplate.queryForMap(
                "select cpr_id, cpr_number, cpr_block, cpr_no_reservation " +
                        "from dcl_commercial_proposal where cpr_number = ? order by cpr_id desc limit 1",
                proposalNumber
        );

        assertEquals(direct.get("cpr_id"), procRows.get(0).get("cpr_id"));
        assertEquals(direct.get("cpr_number"), procRows.get(0).get("cpr_number"));
        assertEquals(1, ((Number) direct.get("cpr_block")).intValue());
        assertEquals(1, ((Number) direct.get("cpr_no_reservation")).intValue());
    }
}
