package net.sam.dcl.modern.dto;

public record ActionDto(
        String id,
        String action,
        String payload
) {
    public static ActionDto empty() {
        return new ActionDto("", "input", "");
    }
}
