package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.MontageAdjustmentHistoryDto;
import org.springframework.stereotype.Service;

@Service
public class MontageAdjustmentHistoryService {

    public MontageAdjustmentHistoryDto load(String id) {
        return new MontageAdjustmentHistoryDto(id == null ? "" : id, "input", "");
    }

    public MontageAdjustmentHistoryDto process(MontageAdjustmentHistoryDto dto) {
        return dto;
    }
}
