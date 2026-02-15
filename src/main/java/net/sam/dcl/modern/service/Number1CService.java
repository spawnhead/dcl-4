package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.Number1CDto;
import org.springframework.stereotype.Service;

@Service
public class Number1CService {

    public Number1CDto load(String id) {
        return new Number1CDto(id == null ? "" : id, "input", "");
    }

    public Number1CDto process(Number1CDto dto) {
        return dto;
    }
}
