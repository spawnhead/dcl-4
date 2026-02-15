package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.WoodworkWorkFilesDto;
import org.springframework.stereotype.Service;

@Service
public class WoodworkWorkFilesService {

    public WoodworkWorkFilesDto load(String id) {
        return new WoodworkWorkFilesDto(id == null ? "" : id, "input", "");
    }

    public WoodworkWorkFilesDto process(WoodworkWorkFilesDto dto) {
        return dto;
    }
}
