package net.sam.dcl.modern.dto;

public record NomenclatureProduceCustomCodeFromHistoryDto(
        String id,
        String action,
        String payload
) {
    public static NomenclatureProduceCustomCodeFromHistoryDto empty() {
        return new NomenclatureProduceCustomCodeFromHistoryDto("", "input", "");
    }
}
