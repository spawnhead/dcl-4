package net.sam.dcl.modern.dto;

public record UserDto(
        String id,
        String action,
        String payload
) {
    public static UserDto empty() {
        return new UserDto("", "input", "");
    }
}
