package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ShippingDto;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public ShippingDto load(String id) {
        return new ShippingDto(id == null ? "" : id, "input", "");
    }

    public ShippingDto process(ShippingDto dto) {
        return dto;
    }
}
