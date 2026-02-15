package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ProduceCostCustomDto;
import org.springframework.stereotype.Service;

@Service
public class ProduceCostCustomService {

    public ProduceCostCustomDto load(String id) {
        return new ProduceCostCustomDto(id == null ? "" : id, "input", "");
    }

    public ProduceCostCustomDto process(ProduceCostCustomDto dto) {
        return dto;
    }
}
