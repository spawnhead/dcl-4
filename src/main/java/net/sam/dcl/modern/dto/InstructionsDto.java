package net.sam.dcl.modern.dto;

public record InstructionsDto(
        String id,
        String action,
        String payload
) {
    public static InstructionsDto empty() {
        return new InstructionsDto("", "input", "");
    }
}
