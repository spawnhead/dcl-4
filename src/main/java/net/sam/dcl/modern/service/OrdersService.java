package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OrdersDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrdersService {

    private final JdbcTemplate jdbcTemplate;

    public OrdersService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public OrdersDto load(String id) {
        return new OrdersDto(id == null ? "" : id, "input", "");
    }

    public OrdersDto process(OrdersDto dto) {
        return dto;
    }

    public List<Map<String, Object>> filterByProcedure(String orderNumber) {
        String sql = "select * from dcl_order_filter(?, null, null)";
        return jdbcTemplate.queryForList(sql, orderNumber);
    }
}
