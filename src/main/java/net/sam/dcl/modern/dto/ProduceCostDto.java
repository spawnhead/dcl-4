package net.sam.dcl.modern.dto;

public record ProduceCostDto(
        String id,
        String action,
        String payload
) {
    public static ProduceCostDto empty() {
        return new ProduceCostDto("", "input", "");
    }
}
