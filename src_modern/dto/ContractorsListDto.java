package net.sam.dcl.modern.dto;

public record ContractorsListDto(
        String id,
        String action,
        String payload
) {
    public static ContractorsListDto empty() {
        return new ContractorsListDto("", "input", "");
    }
}
