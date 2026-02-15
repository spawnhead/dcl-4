package net.sam.dcl.modern.dto;

public record DeliveryRequestsDto(
        String id,
        String action,
        String payload
) {
    public static DeliveryRequestsDto empty() {
        return new DeliveryRequestsDto("", "input", "");
    }
}
