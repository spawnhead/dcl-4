package net.sam.dcl.modern.dto;

public record ContactPersonsListDto(
        String id,
        String action,
        String payload
) {
    public static ContactPersonsListDto empty() {
        return new ContactPersonsListDto("", "input", "");
    }
}
