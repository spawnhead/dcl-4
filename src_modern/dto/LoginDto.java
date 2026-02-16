package net.sam.dcl.modern.dto;

public record LoginDto(
        String id,
        String action,
        String payload
) {
    public static LoginDto empty() {
        return new LoginDto("", "input", "");
    }
}
