package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.BlankDto;
import org.springframework.stereotype.Service;

@Service
public class BlankService {

    public BlankDto load(String id) {
        return new BlankDto(id == null ? "" : id, "input", "");
    }

    public BlankDto process(BlankDto dto) {
        return dto;
    }
}
