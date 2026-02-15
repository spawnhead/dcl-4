package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ActionRolesDto;
import org.springframework.stereotype.Service;

@Service
public class ActionRolesService {

    public ActionRolesDto load(String id) {
        return new ActionRolesDto(id == null ? "" : id, "input", "");
    }

    public ActionRolesDto process(ActionRolesDto dto) {
        return dto;
    }
}
