package net.sam.dcl.modern.dto;

public record SettingDto(
        String id,
        String action,
        String payload
) {
    public static SettingDto empty() {
        return new SettingDto("", "input", "");
    }
}
