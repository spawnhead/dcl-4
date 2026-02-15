package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PurchasePurposesDto;
import org.springframework.stereotype.Service;

@Service
public class PurchasePurposesService {

    public PurchasePurposesDto load(String id) {
        return new PurchasePurposesDto(id == null ? "" : id, "input", "");
    }

    public PurchasePurposesDto process(PurchasePurposesDto dto) {
        return dto;
    }
}
