package net.sam.dcl.modern.dto;

public record ConditionForContractProduceDto(
        String id,
        String action,
        String payload
) {
    public static ConditionForContractProduceDto empty() {
        return new ConditionForContractProduceDto("", "input", "");
    }
}
