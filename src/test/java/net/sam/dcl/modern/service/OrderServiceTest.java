package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrderDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceTest {

    private final OrderService service = new OrderService();

    @Test
    void loadReturnsId() {
        OrderDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        OrderDto dto = new OrderDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
