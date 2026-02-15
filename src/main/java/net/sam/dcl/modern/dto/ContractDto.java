package net.sam.dcl.modern.dto;

public record ContractDto(
        String id,
        String action,
        String payload
) {
    public static ContractDto empty() {
        return new ContractDto("", "input", "");
    }
}
