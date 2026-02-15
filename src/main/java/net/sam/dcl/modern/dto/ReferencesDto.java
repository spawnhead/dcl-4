package net.sam.dcl.modern.dto;

public record ReferencesDto(
        String id,
        String action,
        String payload
) {
    public static ReferencesDto empty() {
        return new ReferencesDto("", "input", "");
    }
}
