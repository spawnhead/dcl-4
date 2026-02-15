package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.MarginDevDto;
import org.springframework.stereotype.Service;

@Service
public class MarginDevService {

    public MarginDevDto load(String id) {
        return new MarginDevDto(id == null ? "" : id, "input", "");
    }

    public MarginDevDto process(MarginDevDto dto) {
        return dto;
    }
}
