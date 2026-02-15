package net.sam.dcl.modern.dto;

public record LockedRecordsOldDto(
        String id,
        String action,
        String payload
) {
    public static LockedRecordsOldDto empty() {
        return new LockedRecordsOldDto("", "input", "");
    }
}
