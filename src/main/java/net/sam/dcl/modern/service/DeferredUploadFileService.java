package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.DeferredUploadFileDto;
import org.springframework.stereotype.Service;

@Service
public class DeferredUploadFileService {

    public DeferredUploadFileDto load(String id) {
        return new DeferredUploadFileDto(id == null ? "" : id, "input", "");
    }

    public DeferredUploadFileDto process(DeferredUploadFileDto dto) {
        return dto;
    }
}
