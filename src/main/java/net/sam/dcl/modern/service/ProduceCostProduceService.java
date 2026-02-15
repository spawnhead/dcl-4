package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ProduceCostProduceDto;
import org.springframework.stereotype.Service;

@Service
public class ProduceCostProduceService {

    public ProduceCostProduceDto load(String id) {
        return new ProduceCostProduceDto(id == null ? "" : id, "input", "");
    }

    public ProduceCostProduceDto process(ProduceCostProduceDto dto) {
        return dto;
    }
}
