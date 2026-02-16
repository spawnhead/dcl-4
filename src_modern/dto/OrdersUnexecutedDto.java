package net.sam.dcl.modern.dto;

public record OrdersUnexecutedDto(
        String id,
        String action,
        String payload
) {
    public static OrdersUnexecutedDto empty() {
        return new OrdersUnexecutedDto("", "input", "");
    }
}
