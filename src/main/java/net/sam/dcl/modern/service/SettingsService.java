package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SettingsDto;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {

    public SettingsDto load(String id) {
        return new SettingsDto(id == null ? "" : id, "input", "");
    }

    public SettingsDto process(SettingsDto dto) {
        return dto;
    }
}
