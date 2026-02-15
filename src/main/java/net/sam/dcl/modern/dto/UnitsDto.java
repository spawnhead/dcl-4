package net.sam.dcl.modern.dto;

public record UnitsDto(
        String id,
        String action,
        String payload
) {
    public static UnitsDto empty() {
        return new UnitsDto("", "input", "");
    }
}
