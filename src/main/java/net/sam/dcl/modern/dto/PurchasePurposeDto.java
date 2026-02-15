package net.sam.dcl.modern.dto;

public record PurchasePurposeDto(
        String id,
        String action,
        String payload
) {
    public static PurchasePurposeDto empty() {
        return new PurchasePurposeDto("", "input", "");
    }
}
