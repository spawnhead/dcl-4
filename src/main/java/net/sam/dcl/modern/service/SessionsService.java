package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SessionsDto;
import org.springframework.stereotype.Service;

@Service
public class SessionsService {

    public SessionsDto load(String id) {
        return new SessionsDto(id == null ? "" : id, "input", "");
    }

    public SessionsDto process(SessionsDto dto) {
        return dto;
    }
}
