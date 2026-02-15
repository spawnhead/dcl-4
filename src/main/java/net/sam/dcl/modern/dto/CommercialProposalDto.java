package net.sam.dcl.modern.dto;

public record CommercialProposalDto(
        String id,
        String action,
        String payload
) {
    public static CommercialProposalDto empty() {
        return new CommercialProposalDto("", "input", "");
    }
}
