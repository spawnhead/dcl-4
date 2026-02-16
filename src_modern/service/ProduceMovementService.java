package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ProduceMovementDto;
import org.springframework.stereotype.Service;

@Service
public class ProduceMovementService {

    public ProduceMovementDto load(String id) {
        return new ProduceMovementDto(id == null ? "" : id, "input", "");
    }

    public ProduceMovementDto process(ProduceMovementDto dto) {
        return dto;
    }
}
