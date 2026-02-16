package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CalculationStateDevDto;
import org.springframework.stereotype.Service;

@Service
public class CalculationStateDevService {

    public CalculationStateDevDto load(String id) {
        return new CalculationStateDevDto(id == null ? "" : id, "input", "");
    }

    public CalculationStateDevDto process(CalculationStateDevDto dto) {
        return dto;
    }
}
