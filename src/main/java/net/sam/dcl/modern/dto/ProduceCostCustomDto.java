package net.sam.dcl.modern.dto;

public record ProduceCostCustomDto(
        String id,
        String action,
        String payload
) {
    public static ProduceCostCustomDto empty() {
        return new ProduceCostCustomDto("", "input", "");
    }
}
