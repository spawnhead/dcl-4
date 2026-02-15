package net.sam.dcl.modern.dto;

public record SerialNumberListDto(
        String id,
        String action,
        String payload
) {
    public static SerialNumberListDto empty() {
        return new SerialNumberListDto("", "input", "");
    }
}
