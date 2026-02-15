package net.sam.dcl.modern.dto;

public record ProduceMovementDto(
        String id,
        String action,
        String payload
) {
    public static ProduceMovementDto empty() {
        return new ProduceMovementDto("", "input", "");
    }
}
