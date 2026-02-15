package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PurchasePurposeDto;
import org.springframework.stereotype.Service;

@Service
public class PurchasePurposeService {

    public PurchasePurposeDto load(String id) {
        return new PurchasePurposeDto(id == null ? "" : id, "input", "");
    }

    public PurchasePurposeDto process(PurchasePurposeDto dto) {
        return dto;
    }
}
