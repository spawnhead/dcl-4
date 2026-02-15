package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.FilesPathsDto;
import org.springframework.stereotype.Service;

@Service
public class FilesPathsService {

    public FilesPathsDto load(String id) {
        return new FilesPathsDto(id == null ? "" : id, "input", "");
    }

    public FilesPathsDto process(FilesPathsDto dto) {
        return dto;
    }
}
