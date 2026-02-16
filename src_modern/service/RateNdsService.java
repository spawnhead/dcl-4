package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.RateNdsDto;
import org.springframework.stereotype.Service;

@Service
public class RateNdsService {

    public RateNdsDto load(String id) {
        return new RateNdsDto(id == null ? "" : id, "input", "");
    }

    public RateNdsDto process(RateNdsDto dto) {
        return dto;
    }
}
