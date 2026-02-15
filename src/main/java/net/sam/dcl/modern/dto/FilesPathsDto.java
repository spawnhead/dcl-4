package net.sam.dcl.modern.dto;

public record FilesPathsDto(
        String id,
        String action,
        String payload
) {
    public static FilesPathsDto empty() {
        return new FilesPathsDto("", "input", "");
    }
}
