package net.sam.dcl.modern.dto;

public record WoodworkWorkFilesDto(
        String id,
        String action,
        String payload
) {
    public static WoodworkWorkFilesDto empty() {
        return new WoodworkWorkFilesDto("", "input", "");
    }
}
