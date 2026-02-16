package net.sam.dcl.modern.dto;

public record ProducesForAssembleMinskDto(
        String id,
        String action,
        String payload
) {
    public static ProducesForAssembleMinskDto empty() {
        return new ProducesForAssembleMinskDto("", "input", "");
    }
}
