package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.OutgoingLetterDto;
import org.springframework.stereotype.Service;

@Service
public class OutgoingLetterService {

    public OutgoingLetterDto load(String id) {
        return new OutgoingLetterDto(id == null ? "" : id, "input", "");
    }

    public OutgoingLetterDto process(OutgoingLetterDto dto) {
        return dto;
    }
}
