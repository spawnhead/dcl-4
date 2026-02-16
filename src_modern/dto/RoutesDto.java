package net.sam.dcl.modern.dto;

public record RoutesDto(
        String id,
        String action,
        String payload
) {
    public static RoutesDto empty() {
        return new RoutesDto("", "input", "");
    }
}
