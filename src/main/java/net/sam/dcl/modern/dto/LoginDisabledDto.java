package net.sam.dcl.modern.dto;

public record LoginDisabledDto(
        String id,
        String action,
        String payload
) {
    public static LoginDisabledDto empty() {
        return new LoginDisabledDto("", "input", "");
    }
}
