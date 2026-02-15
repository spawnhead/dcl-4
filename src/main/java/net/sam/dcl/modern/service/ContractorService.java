package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractorDto;
import org.springframework.stereotype.Service;

@Service
public class ContractorService {

    public ContractorDto load(String id) {
        return new ContractorDto(id == null ? "" : id, "input", "");
    }

    public ContractorDto process(ContractorDto dto) {
        return dto;
    }
}
