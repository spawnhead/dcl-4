package net.sam.dcl.modern.dto;

public record ReputationsDto(
        String id,
        String action,
        String payload
) {
    public static ReputationsDto empty() {
        return new ReputationsDto("", "input", "");
    }
}
