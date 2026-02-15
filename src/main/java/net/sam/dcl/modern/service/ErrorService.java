package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ErrorDto;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {

    public ErrorDto load(String id) {
        return new ErrorDto(id == null ? "" : id, "input", "");
    }

    public ErrorDto process(ErrorDto dto) {
        return dto;
    }
}
