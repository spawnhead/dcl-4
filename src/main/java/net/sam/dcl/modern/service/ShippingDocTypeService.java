package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ShippingDocTypeDto;
import org.springframework.stereotype.Service;

@Service
public class ShippingDocTypeService {

    public ShippingDocTypeDto load(String id) {
        return new ShippingDocTypeDto(id == null ? "" : id, "input", "");
    }

    public ShippingDocTypeDto process(ShippingDocTypeDto dto) {
        return dto;
    }
}
