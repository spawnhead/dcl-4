package net.sam.dcl.modern.dto;

public record SessionsDto(
        String id,
        String action,
        String payload
) {
    public static SessionsDto empty() {
        return new SessionsDto("", "input", "");
    }
}
