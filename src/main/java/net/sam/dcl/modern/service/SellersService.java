package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SellersDto;
import org.springframework.stereotype.Service;

@Service
public class SellersService {

    public SellersDto load(String id) {
        return new SellersDto(id == null ? "" : id, "input", "");
    }

    public SellersDto process(SellersDto dto) {
        return dto;
    }
}
