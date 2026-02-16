package net.sam.dcl.modern.dto;

public record InstructionDto(
        String id,
        String action,
        String payload
) {
    public static InstructionDto empty() {
        return new InstructionDto("", "input", "");
    }
}
