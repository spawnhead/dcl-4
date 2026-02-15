package net.sam.dcl.modern.dto;

public record OrdersDto(
        String id,
        String action,
        String payload
) {
    public static OrdersDto empty() {
        return new OrdersDto("", "input", "");
    }
}
