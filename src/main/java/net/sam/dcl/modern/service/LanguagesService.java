package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.LanguagesDto;
import org.springframework.stereotype.Service;

@Service
public class LanguagesService {

    public LanguagesDto load(String id) {
        return new LanguagesDto(id == null ? "" : id, "input", "");
    }

    public LanguagesDto process(LanguagesDto dto) {
        return dto;
    }
}
