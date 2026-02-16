package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.AssembleDto;
import org.springframework.stereotype.Service;

@Service
public class AssembleService {

    public AssembleDto load(String id) {
        return new AssembleDto(id == null ? "" : id, "input", "");
    }

    public AssembleDto process(AssembleDto dto) {
        return dto;
    }
}
