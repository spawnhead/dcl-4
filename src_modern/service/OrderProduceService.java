package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrderProduceDto;
import org.springframework.stereotype.Service;

@Service
public class OrderProduceService {

    public OrderProduceDto load(String id) {
        return new OrderProduceDto(id == null ? "" : id, "input", "");
    }

    public OrderProduceDto process(OrderProduceDto dto) {
        return dto;
    }
}
