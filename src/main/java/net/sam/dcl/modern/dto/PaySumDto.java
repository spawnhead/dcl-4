package net.sam.dcl.modern.dto;

public record PaySumDto(
        String id,
        String action,
        String payload
) {
    public static PaySumDto empty() {
        return new PaySumDto("", "input", "");
    }
}
