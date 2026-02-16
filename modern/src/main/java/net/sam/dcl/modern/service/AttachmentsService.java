package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.AttachmentsDto;
import org.springframework.stereotype.Service;

@Service
public class AttachmentsService {

    public AttachmentsDto load(String id) {
        return new AttachmentsDto(id == null ? "" : id, "input", "");
    }

    public AttachmentsDto process(AttachmentsDto dto) {
        return dto;
    }
}
