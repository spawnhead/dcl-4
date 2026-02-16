package net.sam.dcl.modern.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LegacyProcedureGateway {

    private final JdbcTemplate jdbcTemplate;

    public LegacyProcedureGateway(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int closeReservedInCommercialProposal() {
        Integer updated = jdbcTemplate.queryForObject("select dcl_close_reserved_in_cpr()", Integer.class);
        return updated == null ? 0 : updated;
    }

    public int saveOrderMessage(Integer orderId, String message) {
        Integer value = jdbcTemplate.queryForObject(
                "select dcl_save_ord_messages(?, ?)",
                Integer.class,
                orderId,
                message
        );
        return value == null ? 0 : value;
    }
}
