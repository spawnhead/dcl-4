package net.sam.dcl.modern.dto;

public record ActionRolesDto(
        String id,
        String action,
        String payload
) {
    public static ActionRolesDto empty() {
        return new ActionRolesDto("", "input", "");
    }
}
