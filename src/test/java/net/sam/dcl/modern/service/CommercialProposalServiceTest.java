package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CommercialProposalDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommercialProposalServiceTest {

    private final CommercialProposalService service = new CommercialProposalService();

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
