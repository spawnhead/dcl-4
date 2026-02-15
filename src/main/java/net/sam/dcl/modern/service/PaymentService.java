package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PaymentDto;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDto load(String id) {
        return new PaymentDto(id == null ? "" : id, "input", "");
    }

    public PaymentDto process(PaymentDto dto) {
        return dto;
    }
}
