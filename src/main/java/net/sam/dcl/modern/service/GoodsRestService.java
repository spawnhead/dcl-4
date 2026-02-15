package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.GoodsRestDto;
import org.springframework.stereotype.Service;

@Service
public class GoodsRestService {

    public GoodsRestDto load(String id) {
        return new GoodsRestDto(id == null ? "" : id, "input", "");
    }

    public GoodsRestDto process(GoodsRestDto dto) {
        return dto;
    }
}
