package net.sam.dcl.modern.dto;

public record StuffCategoriesDto(
        String id,
        String action,
        String payload
) {
    public static StuffCategoriesDto empty() {
        return new StuffCategoriesDto("", "input", "");
    }
}
