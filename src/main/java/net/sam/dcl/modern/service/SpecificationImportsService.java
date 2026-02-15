package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SpecificationImportsDto;
import org.springframework.stereotype.Service;

@Service
public class SpecificationImportsService {

    public SpecificationImportsDto load(String id) {
        return new SpecificationImportsDto(id == null ? "" : id, "input", "");
    }

    public SpecificationImportsDto process(SpecificationImportsDto dto) {
        return dto;
    }
}
