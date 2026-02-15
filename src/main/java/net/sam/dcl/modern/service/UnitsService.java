package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.UnitsDto;
import org.springframework.stereotype.Service;

@Service
public class UnitsService {

    public UnitsDto load(String id) {
        return new UnitsDto(id == null ? "" : id, "input", "");
    }

    public UnitsDto process(UnitsDto dto) {
        return dto;
    }
}
