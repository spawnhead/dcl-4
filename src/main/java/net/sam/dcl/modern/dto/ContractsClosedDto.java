package net.sam.dcl.modern.dto;

public record ContractsClosedDto(
        String id,
        String action,
        String payload
) {
    public static ContractsClosedDto empty() {
        return new ContractsClosedDto("", "input", "");
    }
}
