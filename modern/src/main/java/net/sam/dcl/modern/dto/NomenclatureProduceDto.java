package net.sam.dcl.modern.dto;

public record NomenclatureProduceDto(
        String id,
        String action,
        String payload
) {
    public static NomenclatureProduceDto empty() {
        return new NomenclatureProduceDto("", "input", "");
    }
}
