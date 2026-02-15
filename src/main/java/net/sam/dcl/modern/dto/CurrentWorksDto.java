package net.sam.dcl.modern.dto;

public record CurrentWorksDto(
        String id,
        String action,
        String payload
) {
    public static CurrentWorksDto empty() {
        return new CurrentWorksDto("", "input", "");
    }
}
