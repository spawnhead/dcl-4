package net.sam.dcl.modern.dto;

public record ContractorsDto(
        String id,
        String action,
        String payload
) {
    public static ContractorsDto empty() {
        return new ContractorsDto("", "input", "");
    }
}
