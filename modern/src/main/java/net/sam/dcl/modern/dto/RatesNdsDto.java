package net.sam.dcl.modern.dto;

public record RatesNdsDto(
        String id,
        String action,
        String payload
) {
    public static RatesNdsDto empty() {
        return new RatesNdsDto("", "input", "");
    }
}
