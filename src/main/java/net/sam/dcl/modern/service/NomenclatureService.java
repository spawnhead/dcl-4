package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.NomenclatureDto;
import org.springframework.stereotype.Service;

@Service
public class NomenclatureService {

    public NomenclatureDto load(String id) {
        return new NomenclatureDto(id == null ? "" : id, "input", "");
    }

    public NomenclatureDto process(NomenclatureDto dto) {
        return dto;
    }
}
