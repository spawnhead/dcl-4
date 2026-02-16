package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.DeferredAttachmentsDto;
import org.springframework.stereotype.Service;

@Service
public class DeferredAttachmentsService {

    public DeferredAttachmentsDto load(String id) {
        return new DeferredAttachmentsDto(id == null ? "" : id, "input", "");
    }

    public DeferredAttachmentsDto process(DeferredAttachmentsDto dto) {
        return dto;
    }
}
