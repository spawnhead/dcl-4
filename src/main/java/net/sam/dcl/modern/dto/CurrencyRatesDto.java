package net.sam.dcl.modern.dto;

public record CurrencyRatesDto(
        String id,
        String action,
        String payload
) {
    public static CurrencyRatesDto empty() {
        return new CurrencyRatesDto("", "input", "");
    }
}
