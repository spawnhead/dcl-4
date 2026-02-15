package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CurrencyRatesDto;
import org.springframework.stereotype.Service;

@Service
public class CurrencyRatesService {

    public CurrencyRatesDto load(String id) {
        return new CurrencyRatesDto(id == null ? "" : id, "input", "");
    }

    public CurrencyRatesDto process(CurrencyRatesDto dto) {
        return dto;
    }
}
