package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SpecificationDto;
import org.springframework.stereotype.Service;

@Service
public class SpecificationService {

    public SpecificationDto load(String id) {
        return new SpecificationDto(id == null ? "" : id, "input", "");
    }

    public SpecificationDto process(SpecificationDto dto) {
        return dto;
    }
}
