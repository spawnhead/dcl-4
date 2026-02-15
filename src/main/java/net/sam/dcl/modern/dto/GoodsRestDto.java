package net.sam.dcl.modern.dto;

public record GoodsRestDto(
        String id,
        String action,
        String payload
) {
    public static GoodsRestDto empty() {
        return new GoodsRestDto("", "input", "");
    }
}
