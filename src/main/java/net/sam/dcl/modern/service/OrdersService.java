package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrdersDto;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    public OrdersDto load(String id) {
        return new OrdersDto(id == null ? "" : id, "input", "");
    }

    public OrdersDto process(OrdersDto dto) {
        return dto;
    }
}
