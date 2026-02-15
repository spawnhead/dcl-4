package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.UnitDto;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

    public UnitDto load(String id) {
        return new UnitDto(id == null ? "" : id, "input", "");
    }

    public UnitDto process(UnitDto dto) {
        return dto;
    }
}
