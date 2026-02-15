package net.sam.dcl.modern.dto;

public record ContractsDepFromContractorListDto(
        String id,
        String action,
        String payload
) {
    public static ContractsDepFromContractorListDto empty() {
        return new ContractsDepFromContractorListDto("", "input", "");
    }
}
