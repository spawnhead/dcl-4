package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.JournalsDto;
import org.springframework.stereotype.Service;

@Service
public class JournalsService {

    public JournalsDto load(String id) {
        return new JournalsDto(id == null ? "" : id, "input", "");
    }

    public JournalsDto process(JournalsDto dto) {
        return dto;
    }
}
