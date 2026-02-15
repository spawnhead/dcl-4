package net.sam.dcl.modern.dto;

public record OutgoingLetterDto(
        String id,
        String action,
        String payload
) {
    public static OutgoingLetterDto empty() {
        return new OutgoingLetterDto("", "input", "");
    }
}
