package net.sam.dcl.modern.dto;

public record CountriesDto(
        String id,
        String action,
        String payload
) {
    public static CountriesDto empty() {
        return new CountriesDto("", "input", "");
    }
}
