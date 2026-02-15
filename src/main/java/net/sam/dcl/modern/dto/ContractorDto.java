package net.sam.dcl.modern.dto;

public record ContractorDto(
        String id,
        String action,
        String payload
) {
    public static ContractorDto empty() {
        return new ContractorDto("", "input", "");
    }
}
