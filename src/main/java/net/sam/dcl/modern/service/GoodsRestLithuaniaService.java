package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.GoodsRestLithuaniaDto;
import org.springframework.stereotype.Service;

@Service
public class GoodsRestLithuaniaService {

    public GoodsRestLithuaniaDto load(String id) {
        return new GoodsRestLithuaniaDto(id == null ? "" : id, "input", "");
    }

    public GoodsRestLithuaniaDto process(GoodsRestLithuaniaDto dto) {
        return dto;
    }
}
