package net.sam.dcl.modern.dto;

public record MontageAdjustmentDto(
        String id,
        String action,
        String payload
) {
    public static MontageAdjustmentDto empty() {
        return new MontageAdjustmentDto("", "input", "");
    }
}
