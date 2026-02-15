package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractsDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContractsServiceTest {

    private final ContractsService service = new ContractsService();

    @Test
    void loadReturnsId() {
        ContractsDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        ContractsDto dto = new ContractsDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
