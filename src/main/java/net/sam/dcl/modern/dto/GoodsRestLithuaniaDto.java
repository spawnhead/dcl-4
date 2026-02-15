package net.sam.dcl.modern.dto;

public record GoodsRestLithuaniaDto(
        String id,
        String action,
        String payload
) {
    public static GoodsRestLithuaniaDto empty() {
        return new GoodsRestLithuaniaDto("", "input", "");
    }
}
