package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SpecificationsDepFromContractListDto;
import org.springframework.stereotype.Service;

@Service
public class SpecificationsDepFromContractListService {

    public SpecificationsDepFromContractListDto load(String id) {
        return new SpecificationsDepFromContractListDto(id == null ? "" : id, "input", "");
    }

    public SpecificationsDepFromContractListDto process(SpecificationsDepFromContractListDto dto) {
        return dto;
    }
}
