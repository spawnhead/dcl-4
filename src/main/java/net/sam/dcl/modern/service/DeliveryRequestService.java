package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.DeliveryRequestDto;
import org.springframework.stereotype.Service;

@Service
public class DeliveryRequestService {

    public DeliveryRequestDto load(String id) {
        return new DeliveryRequestDto(id == null ? "" : id, "input", "");
    }

    public DeliveryRequestDto process(DeliveryRequestDto dto) {
        return dto;
    }
}
