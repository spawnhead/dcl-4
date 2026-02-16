package net.sam.dcl.modern.dto;

public record RateNdsDto(
        String id,
        String action,
        String payload
) {
    public static RateNdsDto empty() {
        return new RateNdsDto("", "input", "");
    }
}
