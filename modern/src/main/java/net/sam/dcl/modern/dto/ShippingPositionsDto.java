package net.sam.dcl.modern.dto;

public record ShippingPositionsDto(
        String id,
        String action,
        String payload
) {
    public static ShippingPositionsDto empty() {
        return new ShippingPositionsDto("", "input", "");
    }
}
