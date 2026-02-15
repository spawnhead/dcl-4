package net.sam.dcl.modern.dto;

public record TimeboardsDto(
        String id,
        String action,
        String payload
) {
    public static TimeboardsDto empty() {
        return new TimeboardsDto("", "input", "");
    }
}
