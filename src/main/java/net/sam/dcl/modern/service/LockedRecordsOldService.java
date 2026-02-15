package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.LockedRecordsOldDto;
import org.springframework.stereotype.Service;

@Service
public class LockedRecordsOldService {

    public LockedRecordsOldDto load(String id) {
        return new LockedRecordsOldDto(id == null ? "" : id, "input", "");
    }

    public LockedRecordsOldDto process(LockedRecordsOldDto dto) {
        return dto;
    }
}
