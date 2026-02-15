package net.sam.dcl.modern.dto;

public record LogsDto(
        String id,
        String action,
        String payload
) {
    public static LogsDto empty() {
        return new LogsDto("", "input", "");
    }
}
