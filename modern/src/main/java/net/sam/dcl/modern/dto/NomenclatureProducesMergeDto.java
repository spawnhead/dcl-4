package net.sam.dcl.modern.dto;

public record NomenclatureProducesMergeDto(
        String id,
        String action,
        String payload
) {
    public static NomenclatureProducesMergeDto empty() {
        return new NomenclatureProducesMergeDto("", "input", "");
    }
}
