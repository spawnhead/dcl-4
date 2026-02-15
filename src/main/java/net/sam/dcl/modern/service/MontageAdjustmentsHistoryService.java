package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.MontageAdjustmentsHistoryDto;
import org.springframework.stereotype.Service;

@Service
public class MontageAdjustmentsHistoryService {

    public MontageAdjustmentsHistoryDto load(String id) {
        return new MontageAdjustmentsHistoryDto(id == null ? "" : id, "input", "");
    }

    public MontageAdjustmentsHistoryDto process(MontageAdjustmentsHistoryDto dto) {
        return dto;
    }
}
