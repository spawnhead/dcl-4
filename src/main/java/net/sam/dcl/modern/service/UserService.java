package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDto load(String id) {
        return new UserDto(id == null ? "" : id, "input", "");
    }

    public UserDto process(UserDto dto) {
        return dto;
    }
}
