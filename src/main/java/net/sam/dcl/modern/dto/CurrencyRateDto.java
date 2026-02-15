package net.sam.dcl.modern.dto;

public record CurrencyRateDto(
        String id,
        String action,
        String payload
) {
    public static CurrencyRateDto empty() {
        return new CurrencyRateDto("", "input", "");
    }
}
