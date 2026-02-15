package net.sam.dcl.modern.dto;

public record PurchasePurposesDto(
        String id,
        String action,
        String payload
) {
    public static PurchasePurposesDto empty() {
        return new PurchasePurposesDto("", "input", "");
    }
}
