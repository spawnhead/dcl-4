package net.sam.dcl.modern.dto;

public record UserSettingsDto(
        String id,
        String action,
        String payload
) {
    public static UserSettingsDto empty() {
        return new UserSettingsDto("", "input", "");
    }
}
