package net.sam.dcl.modern.dto;

public record ShippingsDto(
        String id,
        String action,
        String payload
) {
    public static ShippingsDto empty() {
        return new ShippingsDto("", "input", "");
    }
}
