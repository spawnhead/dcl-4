package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractorsForContractsClosedListDto;
import org.springframework.stereotype.Service;

@Service
public class ContractorsForContractsClosedListService {

    public ContractorsForContractsClosedListDto load(String id) {
        return new ContractorsForContractsClosedListDto(id == null ? "" : id, "input", "");
    }

    public ContractorsForContractsClosedListDto process(ContractorsForContractsClosedListDto dto) {
        return dto;
    }
}
