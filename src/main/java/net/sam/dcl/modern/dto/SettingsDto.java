package net.sam.dcl.modern.dto;

public record SettingsDto(
        String id,
        String action,
        String payload
) {
    public static SettingsDto empty() {
        return new SettingsDto("", "input", "");
    }
}
