package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.MergeContractorsDto;
import org.springframework.stereotype.Service;

@Service
public class MergeContractorsService {

    public MergeContractorsDto load(String id) {
        return new MergeContractorsDto(id == null ? "" : id, "input", "");
    }

    public MergeContractorsDto process(MergeContractorsDto dto) {
        return dto;
    }
}
