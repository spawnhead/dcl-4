package net.sam.dcl.modern.dto;

public record ContractorRequestDto(
        String id,
        String action,
        String payload
) {
    public static ContractorRequestDto empty() {
        return new ContractorRequestDto("", "input", "");
    }
}
