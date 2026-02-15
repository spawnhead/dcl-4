package net.sam.dcl.modern.dto;

public record UploadFileDto(
        String id,
        String action,
        String payload
) {
    public static UploadFileDto empty() {
        return new UploadFileDto("", "input", "");
    }
}
