package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.UsersDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersServiceTest {

    private final UsersService service = new UsersService();

    @Test
    void loadReturnsId() {
        UsersDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        UsersDto dto = new UsersDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
