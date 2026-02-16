package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PaySumDto;
import org.springframework.stereotype.Service;

@Service
public class PaySumService {

    public PaySumDto load(String id) {
        return new PaySumDto(id == null ? "" : id, "input", "");
    }

    public PaySumDto process(PaySumDto dto) {
        return dto;
    }
}
