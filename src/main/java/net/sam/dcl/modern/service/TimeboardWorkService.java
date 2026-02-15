package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.TimeboardWorkDto;
import org.springframework.stereotype.Service;

@Service
public class TimeboardWorkService {

    public TimeboardWorkDto load(String id) {
        return new TimeboardWorkDto(id == null ? "" : id, "input", "");
    }

    public TimeboardWorkDto process(TimeboardWorkDto dto) {
        return dto;
    }
}
