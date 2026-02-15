package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ReloaderDto;
import org.springframework.stereotype.Service;

@Service
public class ReloaderService {

    public ReloaderDto load(String id) {
        return new ReloaderDto(id == null ? "" : id, "input", "");
    }

    public ReloaderDto process(ReloaderDto dto) {
        return dto;
    }
}
