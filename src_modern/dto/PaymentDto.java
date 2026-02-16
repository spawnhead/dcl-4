package net.sam.dcl.modern.dto;

public record PaymentDto(
        String id,
        String action,
        String payload
) {
    public static PaymentDto empty() {
        return new PaymentDto("", "input", "");
    }
}
