package net.sam.dcl.modern.dto;

public record AssembleDto(
        String id,
        String action,
        String payload
) {
    public static AssembleDto empty() {
        return new AssembleDto("", "input", "");
    }
}
