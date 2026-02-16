package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ShippingsDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippingsServiceTest {

    private final ShippingsService service = new ShippingsService();

    @Test
    void loadReturnsId() {
        ShippingsDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        ShippingsDto dto = new ShippingsDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
