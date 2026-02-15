package net.sam.dcl.modern.dto;

public record NoPermissionDto(
        String id,
        String action,
        String payload
) {
    public static NoPermissionDto empty() {
        return new NoPermissionDto("", "input", "");
    }
}
