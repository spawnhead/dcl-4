package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ImportFileDto;
import org.springframework.stereotype.Service;

@Service
public class ImportFileService {

    public ImportFileDto load(String id) {
        return new ImportFileDto(id == null ? "" : id, "input", "");
    }

    public ImportFileDto process(ImportFileDto dto) {
        return dto;
    }
}
