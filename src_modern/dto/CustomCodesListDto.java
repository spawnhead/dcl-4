package net.sam.dcl.modern.dto;

public record CustomCodesListDto(
        String id,
        String action,
        String payload
) {
    public static CustomCodesListDto empty() {
        return new CustomCodesListDto("", "input", "");
    }
}
