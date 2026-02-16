package net.sam.dcl.modern.dto;

public record NomenclatureDto(
        String id,
        String action,
        String payload
) {
    public static NomenclatureDto empty() {
        return new NomenclatureDto("", "input", "");
    }
}
