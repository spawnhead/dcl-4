package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.GoodsRestInMinskDto;
import org.springframework.stereotype.Service;

@Service
public class GoodsRestInMinskService {

    public GoodsRestInMinskDto load(String id) {
        return new GoodsRestInMinskDto(id == null ? "" : id, "input", "");
    }

    public GoodsRestInMinskDto process(GoodsRestInMinskDto dto) {
        return dto;
    }
}
