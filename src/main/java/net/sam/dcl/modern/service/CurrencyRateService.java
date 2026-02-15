package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CurrencyRateDto;
import org.springframework.stereotype.Service;

@Service
public class CurrencyRateService {

    public CurrencyRateDto load(String id) {
        return new CurrencyRateDto(id == null ? "" : id, "input", "");
    }

    public CurrencyRateDto process(CurrencyRateDto dto) {
        return dto;
    }
}
