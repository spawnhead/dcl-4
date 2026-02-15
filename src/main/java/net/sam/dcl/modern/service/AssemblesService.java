package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.AssemblesDto;
import org.springframework.stereotype.Service;

@Service
public class AssemblesService {

    public AssemblesDto load(String id) {
        return new AssemblesDto(id == null ? "" : id, "input", "");
    }

    public AssemblesDto process(AssemblesDto dto) {
        return dto;
    }
}
