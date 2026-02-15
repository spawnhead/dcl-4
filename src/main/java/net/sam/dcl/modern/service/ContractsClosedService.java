package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractsClosedDto;
import org.springframework.stereotype.Service;

@Service
public class ContractsClosedService {

    public ContractsClosedDto load(String id) {
        return new ContractsClosedDto(id == null ? "" : id, "input", "");
    }

    public ContractsClosedDto process(ContractsClosedDto dto) {
        return dto;
    }
}
