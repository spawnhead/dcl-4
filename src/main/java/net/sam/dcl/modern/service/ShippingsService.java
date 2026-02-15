package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ShippingsDto;
import org.springframework.stereotype.Service;

@Service
public class ShippingsService {

    public ShippingsDto load(String id) {
        return new ShippingsDto(id == null ? "" : id, "input", "");
    }

    public ShippingsDto process(ShippingsDto dto) {
        return dto;
    }
}
