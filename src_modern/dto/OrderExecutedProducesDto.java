package net.sam.dcl.modern.dto;

public record OrderExecutedProducesDto(
        String id,
        String action,
        String payload
) {
    public static OrderExecutedProducesDto empty() {
        return new OrderExecutedProducesDto("", "input", "");
    }
}
