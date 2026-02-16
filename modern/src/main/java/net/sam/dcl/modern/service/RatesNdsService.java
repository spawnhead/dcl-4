package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.RatesNdsDto;
import org.springframework.stereotype.Service;

@Service
public class RatesNdsService {

    public RatesNdsDto load(String id) {
        return new RatesNdsDto(id == null ? "" : id, "input", "");
    }

    public RatesNdsDto process(RatesNdsDto dto) {
        return dto;
    }
}
