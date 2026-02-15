package net.sam.dcl.modern.dto;

public record Number1CDto(
        String id,
        String action,
        String payload
) {
    public static Number1CDto empty() {
        return new Number1CDto("", "input", "");
    }
}
