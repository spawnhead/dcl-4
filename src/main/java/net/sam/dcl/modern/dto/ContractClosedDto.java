package net.sam.dcl.modern.dto;

public record ContractClosedDto(
        String id,
        String action,
        String payload
) {
    public static ContractClosedDto empty() {
        return new ContractClosedDto("", "input", "");
    }
}
