package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.UsersDto;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    public UsersDto load(String id) {
        return new UsersDto(id == null ? "" : id, "input", "");
    }

    public UsersDto process(UsersDto dto) {
        return dto;
    }
}
