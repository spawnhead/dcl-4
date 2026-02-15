package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CommercialProposalDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommercialProposalService {

    private final JdbcTemplate jdbcTemplate;

    public CommercialProposalService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CommercialProposalDto load(String id) {
        return new CommercialProposalDto(id == null ? "" : id, "input", "");
    }

    public CommercialProposalDto process(CommercialProposalDto dto) {
        return dto;
    }

    public Integer insertViaProcedure(CommercialProposalDto dto, Integer contractorId, Integer userId) {
        String sql = "select dcl_commercial_proposal_insert(?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                java.sql.Date.valueOf(java.time.LocalDate.now()),
                contractorId,
                1,
                1,
                1,
                1,
                userId,
                dto.id() == null || dto.id().isBlank() ? "AUTO" : dto.id()
        );
    }
}
