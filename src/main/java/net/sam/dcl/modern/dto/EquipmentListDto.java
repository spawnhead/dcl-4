package net.sam.dcl.modern.dto;

public record EquipmentListDto(
        String id,
        String action,
        String payload
) {
    public static EquipmentListDto empty() {
        return new EquipmentListDto("", "input", "");
    }
}
