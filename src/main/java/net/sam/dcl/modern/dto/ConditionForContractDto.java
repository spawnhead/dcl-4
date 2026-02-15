package net.sam.dcl.modern.dto;

public record ConditionForContractDto(
        String id,
        String action,
        String payload
) {
    public static ConditionForContractDto empty() {
        return new ConditionForContractDto("", "input", "");
    }
}
