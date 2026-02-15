package net.sam.dcl.modern.dto;

public record SpecificationImportsDto(
        String id,
        String action,
        String payload
) {
    public static SpecificationImportsDto empty() {
        return new SpecificationImportsDto("", "input", "");
    }
}
