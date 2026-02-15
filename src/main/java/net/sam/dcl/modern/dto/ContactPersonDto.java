package net.sam.dcl.modern.dto;

public record ContactPersonDto(
        String id,
        String action,
        String payload
) {
    public static ContactPersonDto empty() {
        return new ContactPersonDto("", "input", "");
    }
}
