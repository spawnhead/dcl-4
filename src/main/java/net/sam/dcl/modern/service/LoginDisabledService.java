package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.LoginDisabledDto;
import org.springframework.stereotype.Service;

@Service
public class LoginDisabledService {

    public LoginDisabledDto load(String id) {
        return new LoginDisabledDto(id == null ? "" : id, "input", "");
    }

    public LoginDisabledDto process(LoginDisabledDto dto) {
        return dto;
    }
}
