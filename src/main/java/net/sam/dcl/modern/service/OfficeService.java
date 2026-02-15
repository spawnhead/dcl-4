package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OfficeDto;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {

    public OfficeDto load(String id) {
        return new OfficeDto(id == null ? "" : id, "input", "");
    }

    public OfficeDto process(OfficeDto dto) {
        return dto;
    }
}
