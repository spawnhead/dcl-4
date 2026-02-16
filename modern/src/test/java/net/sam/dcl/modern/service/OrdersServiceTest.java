package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrdersDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class OrdersServiceTest {

    @Mock JdbcTemplate jdbcTemplate;
    OrdersService service;

    @BeforeEach
    void init() {
        service = new OrdersService(jdbcTemplate);
    }

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
