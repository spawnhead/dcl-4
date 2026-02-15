package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ClosedRecordDto;
import org.springframework.stereotype.Service;

@Service
public class ClosedRecordService {

    public ClosedRecordDto load(String id) {
        return new ClosedRecordDto(id == null ? "" : id, "input", "");
    }

    public ClosedRecordDto process(ClosedRecordDto dto) {
        return dto;
    }
}
