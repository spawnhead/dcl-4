package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrdersDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrdersServiceTest {

    private final OrdersService service = new OrdersService();

    @Test
    void loadReturnsId() {
        OrdersDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        OrdersDto dto = new OrdersDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
