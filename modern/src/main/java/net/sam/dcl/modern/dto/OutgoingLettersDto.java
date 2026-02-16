package net.sam.dcl.modern.dto;

public record OutgoingLettersDto(
        String id,
        String action,
        String payload
) {
    public static OutgoingLettersDto empty() {
        return new OutgoingLettersDto("", "input", "");
    }
}
