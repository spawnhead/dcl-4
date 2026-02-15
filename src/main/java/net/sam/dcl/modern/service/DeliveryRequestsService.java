package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.DeliveryRequestsDto;
import org.springframework.stereotype.Service;

@Service
public class DeliveryRequestsService {

    public DeliveryRequestsDto load(String id) {
        return new DeliveryRequestsDto(id == null ? "" : id, "input", "");
    }

    public DeliveryRequestsDto process(DeliveryRequestsDto dto) {
        return dto;
    }
}
