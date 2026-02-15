package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ShippingPositionsDto;
import org.springframework.stereotype.Service;

@Service
public class ShippingPositionsService {

    public ShippingPositionsDto load(String id) {
        return new ShippingPositionsDto(id == null ? "" : id, "input", "");
    }

    public ShippingPositionsDto process(ShippingPositionsDto dto) {
        return dto;
    }
}
