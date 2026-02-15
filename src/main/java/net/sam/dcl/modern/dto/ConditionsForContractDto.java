package net.sam.dcl.modern.dto;

public record ConditionsForContractDto(
        String id,
        String action,
        String payload
) {
    public static ConditionsForContractDto empty() {
        return new ConditionsForContractDto("", "input", "");
    }
}
