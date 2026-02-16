package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PurposeDto;
import org.springframework.stereotype.Service;

@Service
public class PurposeService {

    public PurposeDto load(String id) {
        return new PurposeDto(id == null ? "" : id, "input", "");
    }

    public PurposeDto process(PurposeDto dto) {
        return dto;
    }
}
