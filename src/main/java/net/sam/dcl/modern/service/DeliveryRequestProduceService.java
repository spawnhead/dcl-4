package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.DeliveryRequestProduceDto;
import org.springframework.stereotype.Service;

@Service
public class DeliveryRequestProduceService {

    public DeliveryRequestProduceDto load(String id) {
        return new DeliveryRequestProduceDto(id == null ? "" : id, "input", "");
    }

    public DeliveryRequestProduceDto process(DeliveryRequestProduceDto dto) {
        return dto;
    }
}
