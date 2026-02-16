package net.sam.dcl.modern.dto;

public record InstructionTypeDto(
        String id,
        String action,
        String payload
) {
    public static InstructionTypeDto empty() {
        return new InstructionTypeDto("", "input", "");
    }
}
