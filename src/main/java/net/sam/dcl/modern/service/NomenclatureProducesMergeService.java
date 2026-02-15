package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.NomenclatureProducesMergeDto;
import org.springframework.stereotype.Service;

@Service
public class NomenclatureProducesMergeService {

    public NomenclatureProducesMergeDto load(String id) {
        return new NomenclatureProducesMergeDto(id == null ? "" : id, "input", "");
    }

    public NomenclatureProducesMergeDto process(NomenclatureProducesMergeDto dto) {
        return dto;
    }
}
