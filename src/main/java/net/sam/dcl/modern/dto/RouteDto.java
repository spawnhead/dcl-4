package net.sam.dcl.modern.dto;

public record RouteDto(
        String id,
        String action,
        String payload
) {
    public static RouteDto empty() {
        return new RouteDto("", "input", "");
    }
}
