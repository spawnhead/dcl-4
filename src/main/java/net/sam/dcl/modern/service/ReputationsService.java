package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ReputationsDto;
import org.springframework.stereotype.Service;

@Service
public class ReputationsService {

    public ReputationsDto load(String id) {
        return new ReputationsDto(id == null ? "" : id, "input", "");
    }

    public ReputationsDto process(ReputationsDto dto) {
        return dto;
    }
}
