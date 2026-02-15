package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CommercialProposalProduceDto;
import org.springframework.stereotype.Service;

@Service
public class CommercialProposalProduceService {

    public CommercialProposalProduceDto load(String id) {
        return new CommercialProposalProduceDto(id == null ? "" : id, "input", "");
    }

    public CommercialProposalProduceDto process(CommercialProposalProduceDto dto) {
        return dto;
    }
}
