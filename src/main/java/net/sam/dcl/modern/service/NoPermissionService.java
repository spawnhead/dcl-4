package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.NoPermissionDto;
import org.springframework.stereotype.Service;

@Service
public class NoPermissionService {

    public NoPermissionDto load(String id) {
        return new NoPermissionDto(id == null ? "" : id, "input", "");
    }

    public NoPermissionDto process(NoPermissionDto dto) {
        return dto;
    }
}
