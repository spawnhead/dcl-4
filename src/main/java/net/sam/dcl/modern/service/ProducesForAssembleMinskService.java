package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ProducesForAssembleMinskDto;
import org.springframework.stereotype.Service;

@Service
public class ProducesForAssembleMinskService {

    public ProducesForAssembleMinskDto load(String id) {
        return new ProducesForAssembleMinskDto(id == null ? "" : id, "input", "");
    }

    public ProducesForAssembleMinskDto process(ProducesForAssembleMinskDto dto) {
        return dto;
    }
}
