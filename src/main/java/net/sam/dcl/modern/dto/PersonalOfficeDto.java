package net.sam.dcl.modern.dto;

public record PersonalOfficeDto(
        String id,
        String action,
        String payload
) {
    public static PersonalOfficeDto empty() {
        return new PersonalOfficeDto("", "input", "");
    }
}
