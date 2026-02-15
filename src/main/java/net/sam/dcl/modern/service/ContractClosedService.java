package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractClosedDto;
import org.springframework.stereotype.Service;

@Service
public class ContractClosedService {

    public ContractClosedDto load(String id) {
        return new ContractClosedDto(id == null ? "" : id, "input", "");
    }

    public ContractClosedDto process(ContractClosedDto dto) {
        return dto;
    }
}
