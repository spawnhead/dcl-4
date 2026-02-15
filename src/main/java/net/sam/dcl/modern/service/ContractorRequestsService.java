package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractorRequestsDto;
import org.springframework.stereotype.Service;

@Service
public class ContractorRequestsService {

    public ContractorRequestsDto load(String id) {
        return new ContractorRequestsDto(id == null ? "" : id, "input", "");
    }

    public ContractorRequestsDto process(ContractorRequestsDto dto) {
        return dto;
    }
}
