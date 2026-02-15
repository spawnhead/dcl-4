package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CustomCodeHistoryDto;
import org.springframework.stereotype.Service;

@Service
public class CustomCodeHistoryService {

    public CustomCodeHistoryDto load(String id) {
        return new CustomCodeHistoryDto(id == null ? "" : id, "input", "");
    }

    public CustomCodeHistoryDto process(CustomCodeHistoryDto dto) {
        return dto;
    }
}
