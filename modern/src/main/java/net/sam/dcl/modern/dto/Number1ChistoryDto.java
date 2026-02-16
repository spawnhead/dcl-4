package net.sam.dcl.modern.dto;

public record Number1ChistoryDto(
        String id,
        String action,
        String payload
) {
    public static Number1ChistoryDto empty() {
        return new Number1ChistoryDto("", "input", "");
    }
}
