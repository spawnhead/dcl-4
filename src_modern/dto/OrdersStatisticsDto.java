package net.sam.dcl.modern.dto;

public record OrdersStatisticsDto(
        String id,
        String action,
        String payload
) {
    public static OrdersStatisticsDto empty() {
        return new OrdersStatisticsDto("", "input", "");
    }
}
