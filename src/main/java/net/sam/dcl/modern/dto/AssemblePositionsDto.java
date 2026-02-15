package net.sam.dcl.modern.dto;

public record AssemblePositionsDto(
        String id,
        String action,
        String payload
) {
    public static AssemblePositionsDto empty() {
        return new AssemblePositionsDto("", "input", "");
    }
}
