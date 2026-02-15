package net.sam.dcl.modern.dto;

public record CalculationStateJustGridDto(
        String id,
        String action,
        String payload
) {
    public static CalculationStateJustGridDto empty() {
        return new CalculationStateJustGridDto("", "input", "");
    }
}
