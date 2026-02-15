package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.MarginDto;
import org.springframework.stereotype.Service;

@Service
public class MarginService {

    public MarginDto load(String id) {
        return new MarginDto(id == null ? "" : id, "input", "");
    }

    public MarginDto process(MarginDto dto) {
        return dto;
    }
}
