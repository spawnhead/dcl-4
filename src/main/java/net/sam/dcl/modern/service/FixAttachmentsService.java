package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.FixAttachmentsDto;
import org.springframework.stereotype.Service;

@Service
public class FixAttachmentsService {

    public FixAttachmentsDto load(String id) {
        return new FixAttachmentsDto(id == null ? "" : id, "input", "");
    }

    public FixAttachmentsDto process(FixAttachmentsDto dto) {
        return dto;
    }
}
