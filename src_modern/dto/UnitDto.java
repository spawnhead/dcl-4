package net.sam.dcl.modern.dto;

public record UnitDto(
        String id,
        String action,
        String payload
) {
    public static UnitDto empty() {
        return new UnitDto("", "input", "");
    }
}
