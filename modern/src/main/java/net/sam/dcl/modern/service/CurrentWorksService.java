package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CurrentWorksDto;
import org.springframework.stereotype.Service;

@Service
public class CurrentWorksService {

    public CurrentWorksDto load(String id) {
        return new CurrentWorksDto(id == null ? "" : id, "input", "");
    }

    public CurrentWorksDto process(CurrentWorksDto dto) {
        return dto;
    }
}
