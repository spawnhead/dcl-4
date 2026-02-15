package net.sam.dcl.modern.dto;

public record SellersDto(
        String id,
        String action,
        String payload
) {
    public static SellersDto empty() {
        return new SellersDto("", "input", "");
    }
}
