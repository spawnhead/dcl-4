package net.sam.dcl.modern.dto;

public record DepartmentDto(
        String id,
        String action,
        String payload
) {
    public static DepartmentDto empty() {
        return new DepartmentDto("", "input", "");
    }
}
