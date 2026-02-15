package net.sam.dcl.modern.dto;

public record ContractorRequestsDto(
        String id,
        String action,
        String payload
) {
    public static ContractorRequestsDto empty() {
        return new ContractorRequestsDto("", "input", "");
    }
}
