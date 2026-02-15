package net.sam.dcl.modern.dto;

public record ProduceCostPositionsDto(
        String id,
        String action,
        String payload
) {
    public static ProduceCostPositionsDto empty() {
        return new ProduceCostPositionsDto("", "input", "");
    }
}
