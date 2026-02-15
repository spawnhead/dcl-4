package net.sam.dcl.modern.dto;

public record DevZoneDto(
        String id,
        String action,
        String payload
) {
    public static DevZoneDto empty() {
        return new DevZoneDto("", "input", "");
    }
}
