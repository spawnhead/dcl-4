package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.NomenclatureProduceDto;
import org.springframework.stereotype.Service;

@Service
public class NomenclatureProduceService {

    public NomenclatureProduceDto load(String id) {
        return new NomenclatureProduceDto(id == null ? "" : id, "input", "");
    }

    public NomenclatureProduceDto process(NomenclatureProduceDto dto) {
        return dto;
    }
}
