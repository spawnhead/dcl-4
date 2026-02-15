package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrdersUnexecutedDto;
import org.springframework.stereotype.Service;

@Service
public class OrdersUnexecutedService {

    public OrdersUnexecutedDto load(String id) {
        return new OrdersUnexecutedDto(id == null ? "" : id, "input", "");
    }

    public OrdersUnexecutedDto process(OrdersUnexecutedDto dto) {
        return dto;
    }
}
