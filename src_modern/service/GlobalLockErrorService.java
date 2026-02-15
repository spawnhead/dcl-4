package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.GlobalLockErrorDto;
import org.springframework.stereotype.Service;

@Service
public class GlobalLockErrorService {

    public GlobalLockErrorDto load(String id) {
        return new GlobalLockErrorDto(id == null ? "" : id, "input", "");
    }

    public GlobalLockErrorDto process(GlobalLockErrorDto dto) {
        return dto;
    }
}
