package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CommercialProposalDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CommercialProposalServiceTest {

    @Mock JdbcTemplate jdbcTemplate;
    @Mock LegacyProcedureGateway legacyProcedureGateway;
    CommercialProposalService service;

    @BeforeEach
    void init() {
        service = new CommercialProposalService(jdbcTemplate, legacyProcedureGateway);
    }

    @Test
    void loadReturnsId() {
        CommercialProposalDto dto = service.load("42");
        assertEquals("42", dto.id());
    }

    @Test
    void processEcho() {
        CommercialProposalDto dto = new CommercialProposalDto("1", "save", "payload");
        assertEquals(dto, service.process(dto));
    }
}
