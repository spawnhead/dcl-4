package net.sam.dcl.modern.dto;

public record GoodsCirculationDto(
        String id,
        String action,
        String payload
) {
    public static GoodsCirculationDto empty() {
        return new GoodsCirculationDto("", "input", "");
    }
}
