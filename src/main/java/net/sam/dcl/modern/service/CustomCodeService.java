package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CustomCodeDto;
import org.springframework.stereotype.Service;

@Service
public class CustomCodeService {

    public CustomCodeDto load(String id) {
        return new CustomCodeDto(id == null ? "" : id, "input", "");
    }

    public CustomCodeDto process(CustomCodeDto dto) {
        return dto;
    }
}
