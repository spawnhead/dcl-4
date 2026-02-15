package net.sam.dcl.modern.dto;

public record MontageAdjustmentsHistoryDto(
        String id,
        String action,
        String payload
) {
    public static MontageAdjustmentsHistoryDto empty() {
        return new MontageAdjustmentsHistoryDto("", "input", "");
    }
}
