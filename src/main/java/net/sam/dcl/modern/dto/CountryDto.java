package net.sam.dcl.modern.dto;

public record CountryDto(
        String id,
        String action,
        String payload
) {
    public static CountryDto empty() {
        return new CountryDto("", "input", "");
    }
}
