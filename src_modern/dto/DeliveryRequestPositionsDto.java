package net.sam.dcl.modern.dto;

public record DeliveryRequestPositionsDto(
        String id,
        String action,
        String payload
) {
    public static DeliveryRequestPositionsDto empty() {
        return new DeliveryRequestPositionsDto("", "input", "");
    }
}
