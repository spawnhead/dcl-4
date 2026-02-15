package net.sam.dcl.modern.dto;

public record ShippingReportDto(
        String id,
        String action,
        String payload
) {
    public static ShippingReportDto empty() {
        return new ShippingReportDto("", "input", "");
    }
}
