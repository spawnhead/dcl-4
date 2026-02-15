package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.InstructionDto;
import org.springframework.stereotype.Service;

@Service
public class InstructionService {

    public InstructionDto load(String id) {
        return new InstructionDto(id == null ? "" : id, "input", "");
    }

    public InstructionDto process(InstructionDto dto) {
        return dto;
    }
}
