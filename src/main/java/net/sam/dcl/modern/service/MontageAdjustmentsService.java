package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.MontageAdjustmentsDto;
import org.springframework.stereotype.Service;

@Service
public class MontageAdjustmentsService {

    public MontageAdjustmentsDto load(String id) {
        return new MontageAdjustmentsDto(id == null ? "" : id, "input", "");
    }

    public MontageAdjustmentsDto process(MontageAdjustmentsDto dto) {
        return dto;
    }
}
