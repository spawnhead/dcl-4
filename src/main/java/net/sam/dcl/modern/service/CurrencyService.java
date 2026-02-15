package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CurrencyDto;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    public CurrencyDto load(String id) {
        return new CurrencyDto(id == null ? "" : id, "input", "");
    }

    public CurrencyDto process(CurrencyDto dto) {
        return dto;
    }
}
