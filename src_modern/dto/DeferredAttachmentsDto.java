package net.sam.dcl.modern.dto;

public record DeferredAttachmentsDto(
        String id,
        String action,
        String payload
) {
    public static DeferredAttachmentsDto empty() {
        return new DeferredAttachmentsDto("", "input", "");
    }
}
