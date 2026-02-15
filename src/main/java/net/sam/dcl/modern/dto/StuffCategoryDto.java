package net.sam.dcl.modern.dto;

public record StuffCategoryDto(
        String id,
        String action,
        String payload
) {
    public static StuffCategoryDto empty() {
        return new StuffCategoryDto("", "input", "");
    }
}
