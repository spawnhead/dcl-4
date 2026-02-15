package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.BlanksDto;
import org.springframework.stereotype.Service;

@Service
public class BlanksService {

    public BlanksDto load(String id) {
        return new BlanksDto(id == null ? "" : id, "input", "");
    }

    public BlanksDto process(BlanksDto dto) {
        return dto;
    }
}
