package net.sam.dcl.modern.dto;

public record MarginDevDto(
        String id,
        String action,
        String payload
) {
    public static MarginDevDto empty() {
        return new MarginDevDto("", "input", "");
    }
}
