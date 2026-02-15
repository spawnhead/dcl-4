package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ReferencesDto;
import org.springframework.stereotype.Service;

@Service
public class ReferencesService {

    public ReferencesDto load(String id) {
        return new ReferencesDto(id == null ? "" : id, "input", "");
    }

    public ReferencesDto process(ReferencesDto dto) {
        return dto;
    }
}
