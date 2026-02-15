package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CustomCodesDto;
import org.springframework.stereotype.Service;

@Service
public class CustomCodesService {

    public CustomCodesDto load(String id) {
        return new CustomCodesDto(id == null ? "" : id, "input", "");
    }

    public CustomCodesDto process(CustomCodesDto dto) {
        return dto;
    }
}
