package net.sam.dcl.modern.dto;

public record FixAttachmentsDto(
        String id,
        String action,
        String payload
) {
    public static FixAttachmentsDto empty() {
        return new FixAttachmentsDto("", "input", "");
    }
}
