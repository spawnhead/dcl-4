package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CustomCodesListDto;
import org.springframework.stereotype.Service;

@Service
public class CustomCodesListService {

    public CustomCodesListDto load(String id) {
        return new CustomCodesListDto(id == null ? "" : id, "input", "");
    }

    public CustomCodesListDto process(CustomCodesListDto dto) {
        return dto;
    }
}
