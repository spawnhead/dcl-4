package net.sam.dcl.modern.dto;

public record MontageAdjustmentHistoryDto(
        String id,
        String action,
        String payload
) {
    public static MontageAdjustmentHistoryDto empty() {
        return new MontageAdjustmentHistoryDto("", "input", "");
    }
}
