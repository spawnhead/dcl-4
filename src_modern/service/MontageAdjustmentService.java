package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.MontageAdjustmentDto;
import org.springframework.stereotype.Service;

@Service
public class MontageAdjustmentService {

    public MontageAdjustmentDto load(String id) {
        return new MontageAdjustmentDto(id == null ? "" : id, "input", "");
    }

    public MontageAdjustmentDto process(MontageAdjustmentDto dto) {
        return dto;
    }
}
