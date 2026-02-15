package net.sam.dcl.modern.dto;

public record OrdersLogisticsDto(
        String id,
        String action,
        String payload
) {
    public static OrdersLogisticsDto empty() {
        return new OrdersLogisticsDto("", "input", "");
    }
}
