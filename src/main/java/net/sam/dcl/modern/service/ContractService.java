package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractDto;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    public ContractDto load(String id) {
        return new ContractDto(id == null ? "" : id, "input", "");
    }

    public ContractDto process(ContractDto dto) {
        return dto;
    }
}
