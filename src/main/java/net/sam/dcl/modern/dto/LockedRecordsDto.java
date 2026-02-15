package net.sam.dcl.modern.dto;

public record LockedRecordsDto(
        String id,
        String action,
        String payload
) {
    public static LockedRecordsDto empty() {
        return new LockedRecordsDto("", "input", "");
    }
}
