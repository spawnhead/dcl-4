package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.FilesPathDto;
import org.springframework.stereotype.Service;

@Service
public class FilesPathService {

    public FilesPathDto load(String id) {
        return new FilesPathDto(id == null ? "" : id, "input", "");
    }

    public FilesPathDto process(FilesPathDto dto) {
        return dto;
    }
}
