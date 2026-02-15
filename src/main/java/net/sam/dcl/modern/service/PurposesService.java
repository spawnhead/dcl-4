package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PurposesDto;
import org.springframework.stereotype.Service;

@Service
public class PurposesService {

    public PurposesDto load(String id) {
        return new PurposesDto(id == null ? "" : id, "input", "");
    }

    public PurposesDto process(PurposesDto dto) {
        return dto;
    }
}
