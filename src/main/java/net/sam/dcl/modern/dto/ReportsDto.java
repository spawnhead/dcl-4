package net.sam.dcl.modern.dto;

public record ReportsDto(
        String id,
        String action,
        String payload
) {
    public static ReportsDto empty() {
        return new ReportsDto("", "input", "");
    }
}
