package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.UploadFileDto;
import org.springframework.stereotype.Service;

@Service
public class UploadFileService {

    public UploadFileDto load(String id) {
        return new UploadFileDto(id == null ? "" : id, "input", "");
    }

    public UploadFileDto process(UploadFileDto dto) {
        return dto;
    }
}
