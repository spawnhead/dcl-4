package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CalculationStateJustGridDto;
import org.springframework.stereotype.Service;

@Service
public class CalculationStateJustGridService {

    public CalculationStateJustGridDto load(String id) {
        return new CalculationStateJustGridDto(id == null ? "" : id, "input", "");
    }

    public CalculationStateJustGridDto process(CalculationStateJustGridDto dto) {
        return dto;
    }
}
