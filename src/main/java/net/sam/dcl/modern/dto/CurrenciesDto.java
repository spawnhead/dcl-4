package net.sam.dcl.modern.dto;

public record CurrenciesDto(
        String id,
        String action,
        String payload
) {
    public static CurrenciesDto empty() {
        return new CurrenciesDto("", "input", "");
    }
}
