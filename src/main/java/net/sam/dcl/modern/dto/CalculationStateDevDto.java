package net.sam.dcl.modern.dto;

public record CalculationStateDevDto(
        String id,
        String action,
        String payload
) {
    public static CalculationStateDevDto empty() {
        return new CalculationStateDevDto("", "input", "");
    }
}
