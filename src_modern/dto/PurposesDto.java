package net.sam.dcl.modern.dto;

public record PurposesDto(
        String id,
        String action,
        String payload
) {
    public static PurposesDto empty() {
        return new PurposesDto("", "input", "");
    }
}
