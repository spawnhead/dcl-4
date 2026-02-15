package net.sam.dcl.modern.dto;

public record AssemblesDto(
        String id,
        String action,
        String payload
) {
    public static AssemblesDto empty() {
        return new AssemblesDto("", "input", "");
    }
}
