package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.MultipleFileUploadDto;
import org.springframework.stereotype.Service;

@Service
public class MultipleFileUploadService {

    public MultipleFileUploadDto load(String id) {
        return new MultipleFileUploadDto(id == null ? "" : id, "input", "");
    }

    public MultipleFileUploadDto process(MultipleFileUploadDto dto) {
        return dto;
    }
}
