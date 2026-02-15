package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractorRequestDto;
import org.springframework.stereotype.Service;

@Service
public class ContractorRequestService {

    public ContractorRequestDto load(String id) {
        return new ContractorRequestDto(id == null ? "" : id, "input", "");
    }

    public ContractorRequestDto process(ContractorRequestDto dto) {
        return dto;
    }
}
