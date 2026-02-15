package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.LogsDto;
import org.springframework.stereotype.Service;

@Service
public class LogsService {

    public LogsDto load(String id) {
        return new LogsDto(id == null ? "" : id, "input", "");
    }

    public LogsDto process(LogsDto dto) {
        return dto;
    }
}
