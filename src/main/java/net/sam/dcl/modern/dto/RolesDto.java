package net.sam.dcl.modern.dto;

public record RolesDto(
        String id,
        String action,
        String payload
) {
    public static RolesDto empty() {
        return new RolesDto("", "input", "");
    }
}
