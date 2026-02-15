package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PaymentsDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentsServiceTest {

    private final PaymentsService service = new PaymentsService();

    @Test
    void loadReturnsId() {
        PaymentsDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        PaymentsDto dto = new PaymentsDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
