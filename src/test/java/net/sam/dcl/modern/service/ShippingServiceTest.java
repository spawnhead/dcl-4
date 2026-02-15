package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ShippingDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippingServiceTest {

    private final ShippingService service = new ShippingService();

    @Test
    void loadReturnsId() {
        ShippingDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        ShippingDto dto = new ShippingDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
