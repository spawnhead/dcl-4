package net.sam.dcl.modern.dto;

public record BlankDto(
        String id,
        String action,
        String payload
) {
    public static BlankDto empty() {
        return new BlankDto("", "input", "");
    }
}
