package net.sam.dcl.modern.dto;

public record DeliveryRequestDto(
        String id,
        String action,
        String payload
) {
    public static DeliveryRequestDto empty() {
        return new DeliveryRequestDto("", "input", "");
    }
}
