package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ShippingDocTypesDto;
import org.springframework.stereotype.Service;

@Service
public class ShippingDocTypesService {

    public ShippingDocTypesDto load(String id) {
        return new ShippingDocTypesDto(id == null ? "" : id, "input", "");
    }

    public ShippingDocTypesDto process(ShippingDocTypesDto dto) {
        return dto;
    }
}
