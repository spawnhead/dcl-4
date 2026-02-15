package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SpecificationImportPositionsDto;
import org.springframework.stereotype.Service;

@Service
public class SpecificationImportPositionsService {

    public SpecificationImportPositionsDto load(String id) {
        return new SpecificationImportPositionsDto(id == null ? "" : id, "input", "");
    }

    public SpecificationImportPositionsDto process(SpecificationImportPositionsDto dto) {
        return dto;
    }
}
