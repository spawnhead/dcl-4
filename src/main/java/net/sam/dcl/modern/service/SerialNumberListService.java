package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SerialNumberListDto;
import org.springframework.stereotype.Service;

@Service
public class SerialNumberListService {

    public SerialNumberListDto load(String id) {
        return new SerialNumberListDto(id == null ? "" : id, "input", "");
    }

    public SerialNumberListDto process(SerialNumberListDto dto) {
        return dto;
    }
}
