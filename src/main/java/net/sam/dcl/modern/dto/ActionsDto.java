package net.sam.dcl.modern.dto;

public record ActionsDto(
        String id,
        String action,
        String payload
) {
    public static ActionsDto empty() {
        return new ActionsDto("", "input", "");
    }
}
