package net.sam.dcl.modern.dto;

public record UsersDto(
        String id,
        String action,
        String payload
) {
    public static UsersDto empty() {
        return new UsersDto("", "input", "");
    }
}
