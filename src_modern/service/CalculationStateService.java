package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CalculationStateDto;
import org.springframework.stereotype.Service;

@Service
public class CalculationStateService {

    public CalculationStateDto load(String id) {
        return new CalculationStateDto(id == null ? "" : id, "input", "");
    }

    public CalculationStateDto process(CalculationStateDto dto) {
        return dto;
    }
}
