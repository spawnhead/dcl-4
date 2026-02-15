package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.NomenclatureProduceCustomCodeHistoryDto;
import org.springframework.stereotype.Service;

@Service
public class NomenclatureProduceCustomCodeHistoryService {

    public NomenclatureProduceCustomCodeHistoryDto load(String id) {
        return new NomenclatureProduceCustomCodeHistoryDto(id == null ? "" : id, "input", "");
    }

    public NomenclatureProduceCustomCodeHistoryDto process(NomenclatureProduceCustomCodeHistoryDto dto) {
        return dto;
    }
}
