package net.sam.dcl.modern.dto;

public record PurposeDto(
        String id,
        String action,
        String payload
) {
    public static PurposeDto empty() {
        return new PurposeDto("", "input", "");
    }
}
