package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractsDto;
import org.springframework.stereotype.Service;

@Service
public class ContractsService {

    public ContractsDto load(String id) {
        return new ContractsDto(id == null ? "" : id, "input", "");
    }

    public ContractsDto process(ContractsDto dto) {
        return dto;
    }
}
