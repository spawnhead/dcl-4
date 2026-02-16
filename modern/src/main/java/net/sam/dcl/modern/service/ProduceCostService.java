package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ProduceCostDto;
import org.springframework.stereotype.Service;

@Service
public class ProduceCostService {

    public ProduceCostDto load(String id) {
        return new ProduceCostDto(id == null ? "" : id, "input", "");
    }

    public ProduceCostDto process(ProduceCostDto dto) {
        return dto;
    }
}
