package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractorsDto;
import org.springframework.stereotype.Service;

@Service
public class ContractorsService {

    public ContractorsDto load(String id) {
        return new ContractorsDto(id == null ? "" : id, "input", "");
    }

    public ContractorsDto process(ContractorsDto dto) {
        return dto;
    }
}
