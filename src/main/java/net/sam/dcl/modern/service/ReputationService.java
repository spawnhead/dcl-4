package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ReputationDto;
import org.springframework.stereotype.Service;

@Service
public class ReputationService {

    public ReputationDto load(String id) {
        return new ReputationDto(id == null ? "" : id, "input", "");
    }

    public ReputationDto process(ReputationDto dto) {
        return dto;
    }
}
