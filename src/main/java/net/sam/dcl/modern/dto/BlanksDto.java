package net.sam.dcl.modern.dto;

public record BlanksDto(
        String id,
        String action,
        String payload
) {
    public static BlanksDto empty() {
        return new BlanksDto("", "input", "");
    }
}
