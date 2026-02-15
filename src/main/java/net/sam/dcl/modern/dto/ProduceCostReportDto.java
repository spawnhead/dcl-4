package net.sam.dcl.modern.dto;

public record ProduceCostReportDto(
        String id,
        String action,
        String payload
) {
    public static ProduceCostReportDto empty() {
        return new ProduceCostReportDto("", "input", "");
    }
}
