package net.sam.dcl.modern.dto;

public record GoodsRestInMinskDto(
        String id,
        String action,
        String payload
) {
    public static GoodsRestInMinskDto empty() {
        return new GoodsRestInMinskDto("", "input", "");
    }
}
