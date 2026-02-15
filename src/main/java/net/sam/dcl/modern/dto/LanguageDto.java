package net.sam.dcl.modern.dto;

public record LanguageDto(
        String id,
        String action,
        String payload
) {
    public static LanguageDto empty() {
        return new LanguageDto("", "input", "");
    }
}
