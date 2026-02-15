package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrdersLogisticsDto;
import org.springframework.stereotype.Service;

@Service
public class OrdersLogisticsService {

    public OrdersLogisticsDto load(String id) {
        return new OrdersLogisticsDto(id == null ? "" : id, "input", "");
    }

    public OrdersLogisticsDto process(OrdersLogisticsDto dto) {
        return dto;
    }
}
