package net.sam.dcl.modern.dto;

public record SpecificationsDepFromContractListDto(
        String id,
        String action,
        String payload
) {
    public static SpecificationsDepFromContractListDto empty() {
        return new SpecificationsDepFromContractListDto("", "input", "");
    }
}
