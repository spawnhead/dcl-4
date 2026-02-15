package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ConditionForContractProduceDto;
import org.springframework.stereotype.Service;

@Service
public class ConditionForContractProduceService {

    public ConditionForContractProduceDto load(String id) {
        return new ConditionForContractProduceDto(id == null ? "" : id, "input", "");
    }

    public ConditionForContractProduceDto process(ConditionForContractProduceDto dto) {
        return dto;
    }
}
