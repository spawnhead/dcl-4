package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrdersStatisticsDto;
import org.springframework.stereotype.Service;

@Service
public class OrdersStatisticsService {

    public OrdersStatisticsDto load(String id) {
        return new OrdersStatisticsDto(id == null ? "" : id, "input", "");
    }

    public OrdersStatisticsDto process(OrdersStatisticsDto dto) {
        return dto;
    }
}
