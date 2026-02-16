package net.sam.dcl.modern.dto;

public record SellerDto(
        String id,
        String action,
        String payload
) {
    public static SellerDto empty() {
        return new SellerDto("", "input", "");
    }
}
