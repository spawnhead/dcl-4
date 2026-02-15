package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.InstructionsDto;
import org.springframework.stereotype.Service;

@Service
public class InstructionsService {

    public InstructionsDto load(String id) {
        return new InstructionsDto(id == null ? "" : id, "input", "");
    }

    public InstructionsDto process(InstructionsDto dto) {
        return dto;
    }
}
