package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractorsListDto;
import org.springframework.stereotype.Service;

@Service
public class ContractorsListService {

    public ContractorsListDto load(String id) {
        return new ContractorsListDto(id == null ? "" : id, "input", "");
    }

    public ContractorsListDto process(ContractorsListDto dto) {
        return dto;
    }
}
