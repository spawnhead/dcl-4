package net.sam.dcl.modern.dto;

public record ReloaderDto(
        String id,
        String action,
        String payload
) {
    public static ReloaderDto empty() {
        return new ReloaderDto("", "input", "");
    }
}
