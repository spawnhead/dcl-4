package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.RoutesDto;
import org.springframework.stereotype.Service;

@Service
public class RoutesService {

    public RoutesDto load(String id) {
        return new RoutesDto(id == null ? "" : id, "input", "");
    }

    public RoutesDto process(RoutesDto dto) {
        return dto;
    }
}
