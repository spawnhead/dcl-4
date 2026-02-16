package net.sam.dcl.modern.integration;

import net.sam.dcl.modern.service.LegacyProcedureGateway;
import net.sam.dcl.modern.service.OrdersService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Tag("integration")
@SpringBootTest
class OrdersIT extends IntegrationPostgresSupport {

    @Autowired
    OrdersService ordersService;

    @Autowired
    LegacyProcedureGateway procedureGateway;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void orderFilterProcedure_returnsRowsForExactOrderNumber() {
        insertOrder("ORD-IT-001", 6101);
        List<Map<String, Object>> rows = ordersService.filterByProcedure("ORD-IT-001");
        assertFalse(rows.isEmpty());
        assertEquals("ORD-IT-001", rows.get(0).get("ord_number"));
    }

    @Test
    void orderFilterProcedure_returnsEmptyForUnknownOrder() {
        List<Map<String, Object>> rows = ordersService.filterByProcedure("ORD-IT-UNKNOWN");
        assertTrue(rows.isEmpty());
    }

    @Test
    void saveOrderMessageProcedure_returnsStatusCode() {
        int status = procedureGateway.saveOrderMessage(999, "integration-message");
        assertTrue(status >= 0);
    }

    @Test
    void orderFilterProcedure_respectsPrefixLikeQuery() {
        insertOrder("ORD-IT-ABC", 6102);
        insertOrder("ORD-IT-ABD", 6103);
        List<Map<String, Object>> rows = ordersService.filterByProcedure("ORD-IT-AB");
        assertEquals(2, rows.size());
    }

    @Test
    void orderFilterProcedure_payloadContainsIdAndNumber() {
        insertOrder("ORD-IT-777", 6104);
        Map<String, Object> row = ordersService.filterByProcedure("ORD-IT-777").get(0);
        assertNotNull(row.get("ord_id"));
        assertEquals("ORD-IT-777", row.get("ord_number"));
    }

    private void insertOrder(String number, int id) {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        jdbcTemplate.update(
                """
                insert into dcl_order (
                    ord_id, ord_create_date, usr_id_create, ord_edit_date, usr_id_edit,
                    ord_number, ord_date, ctr_id, stf_id, cur_id, bln_id, sln_id_for_who
                ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                on conflict (ord_id) do update set ord_number = excluded.ord_number
                """,
                id,
                now,
                1,
                now,
                1,
                number,
                java.sql.Date.valueOf(LocalDate.now()),
                1,
                1,
                1,
                1,
                1
        );
    }
}
