package net.sam.dcl.modern.dto;

public record ProducesCostDto(
        String id,
        String action,
        String payload
) {
    public static ProducesCostDto empty() {
        return new ProducesCostDto("", "input", "");
    }
}
