package net.sam.dcl.modern.dto;

public record ShippingDto(
        String id,
        String action,
        String payload
) {
    public static ShippingDto empty() {
        return new ShippingDto("", "input", "");
    }
}
