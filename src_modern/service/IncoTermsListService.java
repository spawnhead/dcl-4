package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.IncoTermsListDto;
import org.springframework.stereotype.Service;

@Service
public class IncoTermsListService {

    public IncoTermsListDto load(String id) {
        return new IncoTermsListDto(id == null ? "" : id, "input", "");
    }

    public IncoTermsListDto process(IncoTermsListDto dto) {
        return dto;
    }
}
