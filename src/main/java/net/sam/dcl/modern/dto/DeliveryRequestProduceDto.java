package net.sam.dcl.modern.dto;

public record DeliveryRequestProduceDto(
        String id,
        String action,
        String payload
) {
    public static DeliveryRequestProduceDto empty() {
        return new DeliveryRequestProduceDto("", "input", "");
    }
}
