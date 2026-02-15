package net.sam.dcl.modern.dto;

public record UserRolesDto(
        String id,
        String action,
        String payload
) {
    public static UserRolesDto empty() {
        return new UserRolesDto("", "input", "");
    }
}
