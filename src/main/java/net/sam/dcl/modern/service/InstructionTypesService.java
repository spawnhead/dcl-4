package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.InstructionTypesDto;
import org.springframework.stereotype.Service;

@Service
public class InstructionTypesService {

    public InstructionTypesDto load(String id) {
        return new InstructionTypesDto(id == null ? "" : id, "input", "");
    }

    public InstructionTypesDto process(InstructionTypesDto dto) {
        return dto;
    }
}
