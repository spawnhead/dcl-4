package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.GoodsCirculationDto;
import org.springframework.stereotype.Service;

@Service
public class GoodsCirculationService {

    public GoodsCirculationDto load(String id) {
        return new GoodsCirculationDto(id == null ? "" : id, "input", "");
    }

    public GoodsCirculationDto process(GoodsCirculationDto dto) {
        return dto;
    }
}
