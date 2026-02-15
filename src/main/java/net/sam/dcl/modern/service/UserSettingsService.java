package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.UserSettingsDto;
import org.springframework.stereotype.Service;

@Service
public class UserSettingsService {

    public UserSettingsDto load(String id) {
        return new UserSettingsDto(id == null ? "" : id, "input", "");
    }

    public UserSettingsDto process(UserSettingsDto dto) {
        return dto;
    }
}
