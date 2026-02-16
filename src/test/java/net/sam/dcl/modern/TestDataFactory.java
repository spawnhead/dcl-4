package net.sam.dcl.modern;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TestDataFactory {

    private final JdbcTemplate jdbcTemplate;

    public TestDataFactory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void seedCoreData() {
        seedUsers(6);
        seedCommercialProposals(5);
        seedOrders(5);
    }

    public void cleanupAll() {
        jdbcTemplate.update("delete from dcl_order where ord_number like 'SMOKE-ORD-%'");
        jdbcTemplate.update("delete from dcl_commercial_proposal where cpr_number like 'SMOKE-CPR-%'");
        jdbcTemplate.update("delete from dcl_user where usr_id between 9001 and 9099");
    }

    private void seedUsers(int count) {
        for (int i = 0; i < count; i++) {
            int id = 9001 + i;
            jdbcTemplate.update(
                    """
                    insert into dcl_user (usr_id, usr_code, usr_login, usr_passwd, dep_id, usr_block)
                    values (?, ?, ?, ?, ?, ?)
                    on conflict (usr_id) do nothing
                    """,
                    id,
                    "U" + i,
                    "smk" + i,
                    "pwd",
                    1,
                    0
            );
        }
    }

    private void seedCommercialProposals(int count) {
        for (int i = 0; i < count; i++) {
            int id = 8001 + i;
            Timestamp now = Timestamp.valueOf(LocalDateTime.now());
            jdbcTemplate.update(
                    """
                    insert into dcl_commercial_proposal (
                        cpr_id, cpr_create_date, usr_id_create, cpr_edit_date, usr_id_edit,
                        cpr_number, cpr_date, ctr_id, cur_id, trm_id_price_condition,
                        trm_id_delivery_condition, cur_id_table, bln_id,
                        cpr_tender_number_editable, cpr_proposal_declined
                    ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    on conflict (cpr_id) do nothing
                    """,
                    id,
                    now,
                    9001,
                    now,
                    9001,
                    "SMOKE-CPR-" + i,
                    java.sql.Date.valueOf(LocalDate.now()),
                    1,
                    1,
                    1,
                    1,
                    1,
                    1,
                    "0",
                    "0"
            );
        }
    }

    private void seedOrders(int count) {
        for (int i = 0; i < count; i++) {
            int id = 7001 + i;
            Timestamp now = Timestamp.valueOf(LocalDateTime.now());
            jdbcTemplate.update(
                    """
                    insert into dcl_order (
                        ord_id, ord_create_date, usr_id_create, ord_edit_date, usr_id_edit,
                        ord_number, ord_date, ctr_id, stf_id, cur_id, bln_id, sln_id_for_who
                    ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    on conflict (ord_id) do nothing
                    """,
                    id,
                    now,
                    9001,
                    now,
                    9001,
                    "SMOKE-ORD-" + i,
                    java.sql.Date.valueOf(LocalDate.now()),
                    1,
                    1,
                    1,
                    1,
                    1
            );
        }
    }
}
