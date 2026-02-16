package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.LockedRecordsDto;
import org.springframework.stereotype.Service;

@Service
public class LockedRecordsService {

    public LockedRecordsDto load(String id) {
        return new LockedRecordsDto(id == null ? "" : id, "input", "");
    }

    public LockedRecordsDto process(LockedRecordsDto dto) {
        return dto;
    }
}
