package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.InstructionTypeDto;
import org.springframework.stereotype.Service;

@Service
public class InstructionTypeService {

    public InstructionTypeDto load(String id) {
        return new InstructionTypeDto(id == null ? "" : id, "input", "");
    }

    public InstructionTypeDto process(InstructionTypeDto dto) {
        return dto;
    }
}
