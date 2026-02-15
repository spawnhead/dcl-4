package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.DevZoneDto;
import org.springframework.stereotype.Service;

@Service
public class DevZoneService {

    public DevZoneDto load(String id) {
        return new DevZoneDto(id == null ? "" : id, "input", "");
    }

    public DevZoneDto process(DevZoneDto dto) {
        return dto;
    }
}
