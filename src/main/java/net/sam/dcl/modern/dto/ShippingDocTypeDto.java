package net.sam.dcl.modern.dto;

public record ShippingDocTypeDto(
        String id,
        String action,
        String payload
) {
    public static ShippingDocTypeDto empty() {
        return new ShippingDocTypeDto("", "input", "");
    }
}
