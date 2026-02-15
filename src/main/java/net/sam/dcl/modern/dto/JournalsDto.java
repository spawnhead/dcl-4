package net.sam.dcl.modern.dto;

public record JournalsDto(
        String id,
        String action,
        String payload
) {
    public static JournalsDto empty() {
        return new JournalsDto("", "input", "");
    }
}
