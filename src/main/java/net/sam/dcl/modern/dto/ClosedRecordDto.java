package net.sam.dcl.modern.dto;

public record ClosedRecordDto(
        String id,
        String action,
        String payload
) {
    public static ClosedRecordDto empty() {
        return new ClosedRecordDto("", "input", "");
    }
}
