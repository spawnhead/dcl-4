package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.RoleDto;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    public RoleDto load(String id) {
        return new RoleDto(id == null ? "" : id, "input", "");
    }

    public RoleDto process(RoleDto dto) {
        return dto;
    }
}
