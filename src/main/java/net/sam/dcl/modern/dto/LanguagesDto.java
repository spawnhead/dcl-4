package net.sam.dcl.modern.dto;

public record LanguagesDto(
        String id,
        String action,
        String payload
) {
    public static LanguagesDto empty() {
        return new LanguagesDto("", "input", "");
    }
}
