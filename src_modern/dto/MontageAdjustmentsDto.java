package net.sam.dcl.modern.dto;

public record MontageAdjustmentsDto(
        String id,
        String action,
        String payload
) {
    public static MontageAdjustmentsDto empty() {
        return new MontageAdjustmentsDto("", "input", "");
    }
}
