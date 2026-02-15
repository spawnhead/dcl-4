package net.sam.dcl.modern.dto;

public record OrderDto(
        String id,
        String action,
        String payload
) {
    public static OrderDto empty() {
        return new OrderDto("", "input", "");
    }
}
