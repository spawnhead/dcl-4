package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.LoginDto;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginDto load(String id) {
        return new LoginDto(id == null ? "" : id, "input", "");
    }

    public LoginDto process(LoginDto dto) {
        return dto;
    }
}
