package net.sam.dcl.modern.dto;

public record PaymentsDto(
        String id,
        String action,
        String payload
) {
    public static PaymentsDto empty() {
        return new PaymentsDto("", "input", "");
    }
}
