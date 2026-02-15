package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CommercialProposalDto;
import org.springframework.stereotype.Service;

@Service
public class CommercialProposalService {

    public CommercialProposalDto load(String id) {
        return new CommercialProposalDto(id == null ? "" : id, "input", "");
    }

    public CommercialProposalDto process(CommercialProposalDto dto) {
        return dto;
    }
}
