package net.sam.dcl.modern.dto;

public record ContractorsForContractsClosedListDto(
        String id,
        String action,
        String payload
) {
    public static ContractorsForContractsClosedListDto empty() {
        return new ContractorsForContractsClosedListDto("", "input", "");
    }
}
