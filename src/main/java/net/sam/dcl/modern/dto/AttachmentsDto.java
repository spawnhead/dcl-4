package net.sam.dcl.modern.dto;

public record AttachmentsDto(
        String id,
        String action,
        String payload
) {
    public static AttachmentsDto empty() {
        return new AttachmentsDto("", "input", "");
    }
}
