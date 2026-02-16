package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.StuffCategoryDto;
import org.springframework.stereotype.Service;

@Service
public class StuffCategoryService {

    public StuffCategoryDto load(String id) {
        return new StuffCategoryDto(id == null ? "" : id, "input", "");
    }

    public StuffCategoryDto process(StuffCategoryDto dto) {
        return dto;
    }
}
