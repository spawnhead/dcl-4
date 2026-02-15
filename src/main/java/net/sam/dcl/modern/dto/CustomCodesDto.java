package net.sam.dcl.modern.dto;

public record CustomCodesDto(
        String id,
        String action,
        String payload
) {
    public static CustomCodesDto empty() {
        return new CustomCodesDto("", "input", "");
    }
}
