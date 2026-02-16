package net.sam.dcl.modern.dto;

public record CustomCodeDto(
        String id,
        String action,
        String payload
) {
    public static CustomCodeDto empty() {
        return new CustomCodeDto("", "input", "");
    }
}
