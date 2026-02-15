package net.sam.dcl.modern.dto;

public record SellersListDto(
        String id,
        String action,
        String payload
) {
    public static SellersListDto empty() {
        return new SellersListDto("", "input", "");
    }
}
