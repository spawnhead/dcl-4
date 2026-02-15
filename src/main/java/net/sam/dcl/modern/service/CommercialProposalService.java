package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CommercialProposalDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommercialProposalService {

    private final JdbcTemplate jdbcTemplate;
    private final LegacyProcedureGateway procedureGateway;

    public CommercialProposalService(JdbcTemplate jdbcTemplate, LegacyProcedureGateway procedureGateway) {
        this.jdbcTemplate = jdbcTemplate;
        this.procedureGateway = procedureGateway;
    }

    public CommercialProposalDto load(String id) {
        return new CommercialProposalDto(id == null ? "" : id, "input", "");
    }

    public CommercialProposalDto process(CommercialProposalDto dto) {
        if (!"save".equalsIgnoreCase(dto.action())) {
            return dto;
        }

        Integer generatedId = insertViaProcedure(dto, 1, 1);
        procedureGateway.closeReservedInCommercialProposal();
        return new CommercialProposalDto(
                generatedId == null ? dto.id() : String.valueOf(generatedId),
                dto.action(),
                dto.payload()
        );
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

    public List<Map<String, Object>> filterByProcedure(String proposalNumber) {
        return jdbcTemplate.queryForList(
                "select * from dcl_commercial_proposal_filter(?, null, null, null)",
                proposalNumber
        );
    }
}
