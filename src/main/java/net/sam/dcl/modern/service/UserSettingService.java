package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.UserSettingDto;
import org.springframework.stereotype.Service;

@Service
public class UserSettingService {

    public UserSettingDto load(String id) {
        return new UserSettingDto(id == null ? "" : id, "input", "");
    }

    public UserSettingDto process(UserSettingDto dto) {
        return dto;
    }
}
