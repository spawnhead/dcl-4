package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContractServiceTest {

    private final ContractService service = new ContractService();

    @Test
    void loadReturnsId() {
        ContractDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        ContractDto dto = new ContractDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
