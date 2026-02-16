package net.sam.dcl.modern.dto;

public record ShippingDocTypesDto(
        String id,
        String action,
        String payload
) {
    public static ShippingDocTypesDto empty() {
        return new ShippingDocTypesDto("", "input", "");
    }
}
