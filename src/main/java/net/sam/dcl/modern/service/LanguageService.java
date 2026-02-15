package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.LanguageDto;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    public LanguageDto load(String id) {
        return new LanguageDto(id == null ? "" : id, "input", "");
    }

    public LanguageDto process(LanguageDto dto) {
        return dto;
    }
}
