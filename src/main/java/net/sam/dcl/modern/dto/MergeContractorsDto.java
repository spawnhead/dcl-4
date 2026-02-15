package net.sam.dcl.modern.dto;

public record MergeContractorsDto(
        String id,
        String action,
        String payload
) {
    public static MergeContractorsDto empty() {
        return new MergeContractorsDto("", "input", "");
    }
}
