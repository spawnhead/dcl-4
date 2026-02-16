package net.sam.dcl.modern.dto;

public record TimeboardDto(
        String id,
        String action,
        String payload
) {
    public static TimeboardDto empty() {
        return new TimeboardDto("", "input", "");
    }
}
