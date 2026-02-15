package net.sam.dcl.modern.dto;

public record FilesPathDto(
        String id,
        String action,
        String payload
) {
    public static FilesPathDto empty() {
        return new FilesPathDto("", "input", "");
    }
}
