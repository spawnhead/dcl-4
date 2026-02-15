package net.sam.dcl.modern.dto;

public record TimeboardWorkDto(
        String id,
        String action,
        String payload
) {
    public static TimeboardWorkDto empty() {
        return new TimeboardWorkDto("", "input", "");
    }
}
