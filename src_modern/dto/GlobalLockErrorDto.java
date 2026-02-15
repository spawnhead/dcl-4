package net.sam.dcl.modern.dto;

public record GlobalLockErrorDto(
        String id,
        String action,
        String payload
) {
    public static GlobalLockErrorDto empty() {
        return new GlobalLockErrorDto("", "input", "");
    }
}
