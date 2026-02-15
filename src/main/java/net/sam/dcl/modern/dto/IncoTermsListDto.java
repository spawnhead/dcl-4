package net.sam.dcl.modern.dto;

public record IncoTermsListDto(
        String id,
        String action,
        String payload
) {
    public static IncoTermsListDto empty() {
        return new IncoTermsListDto("", "input", "");
    }
}
