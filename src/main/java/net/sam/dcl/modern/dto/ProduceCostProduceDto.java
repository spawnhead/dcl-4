package net.sam.dcl.modern.dto;

public record ProduceCostProduceDto(
        String id,
        String action,
        String payload
) {
    public static ProduceCostProduceDto empty() {
        return new ProduceCostProduceDto("", "input", "");
    }
}
