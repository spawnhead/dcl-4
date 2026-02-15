package net.sam.dcl.modern.dto;

public record SpecificationImportDto(
        String id,
        String action,
        String payload
) {
    public static SpecificationImportDto empty() {
        return new SpecificationImportDto("", "input", "");
    }
}
