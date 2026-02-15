package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CommercialProposalsDto;
import org.springframework.stereotype.Service;

@Service
public class CommercialProposalsService {

    public CommercialProposalsDto load(String id) {
        return new CommercialProposalsDto(id == null ? "" : id, "input", "");
    }

    public CommercialProposalsDto process(CommercialProposalsDto dto) {
        return dto;
    }
}
