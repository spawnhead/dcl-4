package net.sam.dcl.modern.dto;

public record SpecificationDto(
        String id,
        String action,
        String payload
) {
    public static SpecificationDto empty() {
        return new SpecificationDto("", "input", "");
    }
}
