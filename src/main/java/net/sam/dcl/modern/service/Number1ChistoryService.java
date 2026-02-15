package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.Number1ChistoryDto;
import org.springframework.stereotype.Service;

@Service
public class Number1ChistoryService {

    public Number1ChistoryDto load(String id) {
        return new Number1ChistoryDto(id == null ? "" : id, "input", "");
    }

    public Number1ChistoryDto process(Number1ChistoryDto dto) {
        return dto;
    }
}
