package net.sam.dcl.modern.dto;

public record SpecificationImportPositionsDto(
        String id,
        String action,
        String payload
) {
    public static SpecificationImportPositionsDto empty() {
        return new SpecificationImportPositionsDto("", "input", "");
    }
}
