package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ConditionsForContractDto;
import org.springframework.stereotype.Service;

@Service
public class ConditionsForContractService {

    public ConditionsForContractDto load(String id) {
        return new ConditionsForContractDto(id == null ? "" : id, "input", "");
    }

    public ConditionsForContractDto process(ConditionsForContractDto dto) {
        return dto;
    }
}
