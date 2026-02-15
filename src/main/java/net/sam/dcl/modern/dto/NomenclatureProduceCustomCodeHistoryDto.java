package net.sam.dcl.modern.dto;

public record NomenclatureProduceCustomCodeHistoryDto(
        String id,
        String action,
        String payload
) {
    public static NomenclatureProduceCustomCodeHistoryDto empty() {
        return new NomenclatureProduceCustomCodeHistoryDto("", "input", "");
    }
}
