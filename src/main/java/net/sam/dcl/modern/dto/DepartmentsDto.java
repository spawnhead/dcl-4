package net.sam.dcl.modern.dto;

public record DepartmentsDto(
        String id,
        String action,
        String payload
) {
    public static DepartmentsDto empty() {
        return new DepartmentsDto("", "input", "");
    }
}
