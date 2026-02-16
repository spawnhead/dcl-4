package net.sam.dcl.modern.integration;

import net.sam.dcl.modern.dto.CommercialProposalDto;
import net.sam.dcl.modern.service.CommercialProposalService;
import net.sam.dcl.modern.service.LegacyProcedureGateway;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Tag("integration")
@SpringBootTest
class CommercialProposalIT extends IntegrationPostgresSupport {

    @Autowired
    CommercialProposalService service;

    @Autowired
    LegacyProcedureGateway procedureGateway;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void insertViaProcedure_generatesId() {
        Integer id = service.insertViaProcedure(new CommercialProposalDto("CPR-IT-01", "save", "it"), 1, 1);
        assertNotNull(id);
        assertTrue(id > 0);
    }

    @Test
    void processSave_persistsAndReturnsGeneratedId() {
        CommercialProposalDto result = service.process(new CommercialProposalDto("CPR-IT-02", "save", "payload"));
        assertNotNull(result.id());

        Integer count = jdbcTemplate.queryForObject(
                "select count(*) from dcl_commercial_proposal where cpr_number = ?",
                Integer.class,
                "CPR-IT-02"
        );
        assertNotNull(count);
        assertTrue(count > 0);
    }

    @Test
    void filterByProcedure_returnsInsertedRow() {
        service.insertViaProcedure(new CommercialProposalDto("CPR-IT-03", "save", "x"), 1, 1);
        List<Map<String, Object>> rows = service.filterByProcedure("CPR-IT-03");
        assertFalse(rows.isEmpty());
        assertEquals("CPR-IT-03", rows.get(0).get("cpr_number"));
    }

    @Test
    void closeReservedProcedure_executesWithoutError() {
        int updated = procedureGateway.closeReservedInCommercialProposal();
        assertTrue(updated >= 0);
    }

    @Test
    void insertedProposal_hasLegacyDefaultFlags() {
        Integer id = service.insertViaProcedure(new CommercialProposalDto("CPR-IT-04", "save", ""), 1, 1);
        Map<String, Object> row = jdbcTemplate.queryForMap(
                "select cpr_block, cpr_no_reservation from dcl_commercial_proposal where cpr_id = ?",
                id
        );
        assertEquals(1, ((Number) row.get("cpr_block")).intValue());
        assertEquals(1, ((Number) row.get("cpr_no_reservation")).intValue());
    }
}
