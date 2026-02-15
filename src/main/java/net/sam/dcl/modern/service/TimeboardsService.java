package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.TimeboardsDto;
import org.springframework.stereotype.Service;

@Service
public class TimeboardsService {

    public TimeboardsDto load(String id) {
        return new TimeboardsDto(id == null ? "" : id, "input", "");
    }

    public TimeboardsDto process(TimeboardsDto dto) {
        return dto;
    }
}
