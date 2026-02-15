package net.sam.dcl.modern.dto;

public record OfficeDto(
        String id,
        String action,
        String payload
) {
    public static OfficeDto empty() {
        return new OfficeDto("", "input", "");
    }
}
