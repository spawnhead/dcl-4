package net.sam.dcl.modern.dto;

public record ErrorDto(
        String id,
        String action,
        String payload
) {
    public static ErrorDto empty() {
        return new ErrorDto("", "input", "");
    }
}
