package net.sam.dcl.modern.dto;

public record ReputationDto(
        String id,
        String action,
        String payload
) {
    public static ReputationDto empty() {
        return new ReputationDto("", "input", "");
    }
}
