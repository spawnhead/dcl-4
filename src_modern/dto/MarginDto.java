package net.sam.dcl.modern.dto;

public record MarginDto(
        String id,
        String action,
        String payload
) {
    public static MarginDto empty() {
        return new MarginDto("", "input", "");
    }
}
