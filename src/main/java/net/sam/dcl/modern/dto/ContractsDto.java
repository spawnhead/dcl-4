package net.sam.dcl.modern.dto;

public record ContractsDto(
        String id,
        String action,
        String payload
) {
    public static ContractsDto empty() {
        return new ContractsDto("", "input", "");
    }
}
