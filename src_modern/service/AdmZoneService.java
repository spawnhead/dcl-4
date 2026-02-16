package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.AdmZoneDto;
import org.springframework.stereotype.Service;

@Service
public class AdmZoneService {

    public AdmZoneDto load(String id) {
        return new AdmZoneDto(id == null ? "" : id, "input", "");
    }

    public AdmZoneDto process(AdmZoneDto dto) {
        return dto;
    }
}
