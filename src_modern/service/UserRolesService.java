package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.UserRolesDto;
import org.springframework.stereotype.Service;

@Service
public class UserRolesService {

    public UserRolesDto load(String id) {
        return new UserRolesDto(id == null ? "" : id, "input", "");
    }

    public UserRolesDto process(UserRolesDto dto) {
        return dto;
    }
}
