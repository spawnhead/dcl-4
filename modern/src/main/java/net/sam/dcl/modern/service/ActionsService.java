package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ActionsDto;
import org.springframework.stereotype.Service;

@Service
public class ActionsService {

    public ActionsDto load(String id) {
        return new ActionsDto(id == null ? "" : id, "input", "");
    }

    public ActionsDto process(ActionsDto dto) {
        return dto;
    }
}
