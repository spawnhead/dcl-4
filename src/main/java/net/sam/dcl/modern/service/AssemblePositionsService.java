package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.AssemblePositionsDto;
import org.springframework.stereotype.Service;

@Service
public class AssemblePositionsService {

    public AssemblePositionsDto load(String id) {
        return new AssemblePositionsDto(id == null ? "" : id, "input", "");
    }

    public AssemblePositionsDto process(AssemblePositionsDto dto) {
        return dto;
    }
}
