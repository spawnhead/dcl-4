package net.sam.dcl.modern.dto;

public record CustomCodeHistoryDto(
        String id,
        String action,
        String payload
) {
    public static CustomCodeHistoryDto empty() {
        return new CustomCodeHistoryDto("", "input", "");
    }
}
