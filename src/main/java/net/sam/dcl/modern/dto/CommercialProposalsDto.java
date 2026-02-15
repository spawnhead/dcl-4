package net.sam.dcl.modern.dto;

public record CommercialProposalsDto(
        String id,
        String action,
        String payload
) {
    public static CommercialProposalsDto empty() {
        return new CommercialProposalsDto("", "input", "");
    }
}
