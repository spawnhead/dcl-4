package net.sam.dcl.modern.dto;

public record CommercialProposalProduceDto(
        String id,
        String action,
        String payload
) {
    public static CommercialProposalProduceDto empty() {
        return new CommercialProposalProduceDto("", "input", "");
    }
}
