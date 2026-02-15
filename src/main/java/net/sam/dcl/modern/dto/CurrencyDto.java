package net.sam.dcl.modern.dto;

public record CurrencyDto(
        String id,
        String action,
        String payload
) {
    public static CurrencyDto empty() {
        return new CurrencyDto("", "input", "");
    }
}
