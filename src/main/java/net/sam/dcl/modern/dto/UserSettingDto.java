package net.sam.dcl.modern.dto;

public record UserSettingDto(
        String id,
        String action,
        String payload
) {
    public static UserSettingDto empty() {
        return new UserSettingDto("", "input", "");
    }
}
