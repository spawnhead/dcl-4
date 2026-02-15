package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SpecificationImportDto;
import org.springframework.stereotype.Service;

@Service
public class SpecificationImportService {

    public SpecificationImportDto load(String id) {
        return new SpecificationImportDto(id == null ? "" : id, "input", "");
    }

    public SpecificationImportDto process(SpecificationImportDto dto) {
        return dto;
    }
}
