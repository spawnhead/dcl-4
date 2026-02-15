package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PaymentsDto;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {

    public PaymentsDto load(String id) {
        return new PaymentsDto(id == null ? "" : id, "input", "");
    }

    public PaymentsDto process(PaymentsDto dto) {
        return dto;
    }
}
