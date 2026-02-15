package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.TimeboardDto;
import org.springframework.stereotype.Service;

@Service
public class TimeboardService {

    public TimeboardDto load(String id) {
        return new TimeboardDto(id == null ? "" : id, "input", "");
    }

    public TimeboardDto process(TimeboardDto dto) {
        return dto;
    }
}
