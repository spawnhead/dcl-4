package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.RouteDto;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    public RouteDto load(String id) {
        return new RouteDto(id == null ? "" : id, "input", "");
    }

    public RouteDto process(RouteDto dto) {
        return dto;
    }
}
