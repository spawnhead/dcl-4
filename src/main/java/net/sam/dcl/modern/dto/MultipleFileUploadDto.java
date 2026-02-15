package net.sam.dcl.modern.dto;

public record MultipleFileUploadDto(
        String id,
        String action,
        String payload
) {
    public static MultipleFileUploadDto empty() {
        return new MultipleFileUploadDto("", "input", "");
    }
}
