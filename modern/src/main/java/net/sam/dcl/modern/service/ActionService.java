package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ActionDto;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    public ActionDto load(String id) {
        return new ActionDto(id == null ? "" : id, "input", "");
    }

    public ActionDto process(ActionDto dto) {
        return dto;
    }
}
