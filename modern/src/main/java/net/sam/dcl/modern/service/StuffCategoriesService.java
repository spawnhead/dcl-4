package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.StuffCategoriesDto;
import org.springframework.stereotype.Service;

@Service
public class StuffCategoriesService {

    public StuffCategoriesDto load(String id) {
        return new StuffCategoriesDto(id == null ? "" : id, "input", "");
    }

    public StuffCategoriesDto process(StuffCategoriesDto dto) {
        return dto;
    }
}
