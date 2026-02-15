package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.InvitationDto;
import org.springframework.stereotype.Service;

@Service
public class InvitationService {

    public InvitationDto load(String id) {
        return new InvitationDto(id == null ? "" : id, "input", "");
    }

    public InvitationDto process(InvitationDto dto) {
        return dto;
    }
}
