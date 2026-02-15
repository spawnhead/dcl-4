package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.DeliveryRequestPositionsDto;
import org.springframework.stereotype.Service;

@Service
public class DeliveryRequestPositionsService {

    public DeliveryRequestPositionsDto load(String id) {
        return new DeliveryRequestPositionsDto(id == null ? "" : id, "input", "");
    }

    public DeliveryRequestPositionsDto process(DeliveryRequestPositionsDto dto) {
        return dto;
    }
}
