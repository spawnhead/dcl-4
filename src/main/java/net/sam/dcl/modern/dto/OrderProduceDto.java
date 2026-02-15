package net.sam.dcl.modern.dto;

public record OrderProduceDto(
        String id,
        String action,
        String payload
) {
    public static OrderProduceDto empty() {
        return new OrderProduceDto("", "input", "");
    }
}
