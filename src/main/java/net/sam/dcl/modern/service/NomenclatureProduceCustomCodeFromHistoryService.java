package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.NomenclatureProduceCustomCodeFromHistoryDto;
import org.springframework.stereotype.Service;

@Service
public class NomenclatureProduceCustomCodeFromHistoryService {

    public NomenclatureProduceCustomCodeFromHistoryDto load(String id) {
        return new NomenclatureProduceCustomCodeFromHistoryDto(id == null ? "" : id, "input", "");
    }

    public NomenclatureProduceCustomCodeFromHistoryDto process(NomenclatureProduceCustomCodeFromHistoryDto dto) {
        return dto;
    }
}
