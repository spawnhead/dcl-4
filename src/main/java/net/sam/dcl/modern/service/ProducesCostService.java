package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ProducesCostDto;
import org.springframework.stereotype.Service;

@Service
public class ProducesCostService {

    public ProducesCostDto load(String id) {
        return new ProducesCostDto(id == null ? "" : id, "input", "");
    }

    public ProducesCostDto process(ProducesCostDto dto) {
        return dto;
    }
}
