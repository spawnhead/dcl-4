package net.sam.dcl.modern.dto;

public record InstructionTypesDto(
        String id,
        String action,
        String payload
) {
    public static InstructionTypesDto empty() {
        return new InstructionTypesDto("", "input", "");
    }
}
