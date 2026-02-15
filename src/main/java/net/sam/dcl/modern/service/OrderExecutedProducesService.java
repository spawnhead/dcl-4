package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrderExecutedProducesDto;
import org.springframework.stereotype.Service;

@Service
public class OrderExecutedProducesService {

    public OrderExecutedProducesDto load(String id) {
        return new OrderExecutedProducesDto(id == null ? "" : id, "input", "");
    }

    public OrderExecutedProducesDto process(OrderExecutedProducesDto dto) {
        return dto;
    }
}
