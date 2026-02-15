package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OutgoingLettersDto;
import org.springframework.stereotype.Service;

@Service
public class OutgoingLettersService {

    public OutgoingLettersDto load(String id) {
        return new OutgoingLettersDto(id == null ? "" : id, "input", "");
    }

    public OutgoingLettersDto process(OutgoingLettersDto dto) {
        return dto;
    }
}
