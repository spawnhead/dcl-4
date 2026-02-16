package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.RolesDto;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    public RolesDto load(String id) {
        return new RolesDto(id == null ? "" : id, "input", "");
    }

    public RolesDto process(RolesDto dto) {
        return dto;
    }
}
