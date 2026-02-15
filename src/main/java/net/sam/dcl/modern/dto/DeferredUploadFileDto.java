package net.sam.dcl.modern.dto;

public record DeferredUploadFileDto(
        String id,
        String action,
        String payload
) {
    public static DeferredUploadFileDto empty() {
        return new DeferredUploadFileDto("", "input", "");
    }
}
