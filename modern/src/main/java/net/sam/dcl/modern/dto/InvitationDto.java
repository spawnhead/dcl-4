package net.sam.dcl.modern.dto;

public record InvitationDto(
        String id,
        String action,
        String payload
) {
    public static InvitationDto empty() {
        return new InvitationDto("", "input", "");
    }
}
