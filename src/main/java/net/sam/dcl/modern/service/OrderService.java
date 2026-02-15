package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrderDto;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public OrderDto load(String id) {
        return new OrderDto(id == null ? "" : id, "input", "");
    }

    public OrderDto process(OrderDto dto) {
        return dto;
    }
}
