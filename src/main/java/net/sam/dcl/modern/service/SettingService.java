package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SettingDto;
import org.springframework.stereotype.Service;

@Service
public class SettingService {

    public SettingDto load(String id) {
        return new SettingDto(id == null ? "" : id, "input", "");
    }

    public SettingDto process(SettingDto dto) {
        return dto;
    }
}
