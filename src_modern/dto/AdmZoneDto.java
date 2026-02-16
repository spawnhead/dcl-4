package net.sam.dcl.modern.dto;

public record AdmZoneDto(
        String id,
        String action,
        String payload
) {
    public static AdmZoneDto empty() {
        return new AdmZoneDto("", "input", "");
    }
}
