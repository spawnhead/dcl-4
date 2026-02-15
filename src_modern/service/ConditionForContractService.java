package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ConditionForContractDto;
import org.springframework.stereotype.Service;

@Service
public class ConditionForContractService {

    public ConditionForContractDto load(String id) {
        return new ConditionForContractDto(id == null ? "" : id, "input", "");
    }

    public ConditionForContractDto process(ConditionForContractDto dto) {
        return dto;
    }
}
