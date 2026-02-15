package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PaymentDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentServiceTest {

    private final PaymentService service = new PaymentService();

    @Test
    void loadReturnsId() {
        PaymentDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        PaymentDto dto = new PaymentDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
