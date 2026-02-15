package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContractsDepFromContractorListDto;
import org.springframework.stereotype.Service;

@Service
public class ContractsDepFromContractorListService {

    public ContractsDepFromContractorListDto load(String id) {
        return new ContractsDepFromContractorListDto(id == null ? "" : id, "input", "");
    }

    public ContractsDepFromContractorListDto process(ContractsDepFromContractorListDto dto) {
        return dto;
    }
}
