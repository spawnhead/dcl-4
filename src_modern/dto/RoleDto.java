package net.sam.dcl.modern.dto;

public record RoleDto(
        String id,
        String action,
        String payload
) {
    public static RoleDto empty() {
        return new RoleDto("", "input", "");
    }
}
