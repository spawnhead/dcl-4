package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ProduceCostPositionsDto;
import org.springframework.stereotype.Service;

@Service
public class ProduceCostPositionsService {

    public ProduceCostPositionsDto load(String id) {
        return new ProduceCostPositionsDto(id == null ? "" : id, "input", "");
    }

    public ProduceCostPositionsDto process(ProduceCostPositionsDto dto) {
        return dto;
    }
}
