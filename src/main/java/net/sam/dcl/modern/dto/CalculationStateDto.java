package net.sam.dcl.modern.dto;

public record CalculationStateDto(
        String id,
        String action,
        String payload
) {
    public static CalculationStateDto empty() {
        return new CalculationStateDto("", "input", "");
    }
}
