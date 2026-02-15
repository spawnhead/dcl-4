package net.sam.dcl.modern.dto;

public record ImportFileDto(
        String id,
        String action,
        String payload
) {
    public static ImportFileDto empty() {
        return new ImportFileDto("", "input", "");
    }
}
