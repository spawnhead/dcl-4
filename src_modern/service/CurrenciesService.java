package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CurrenciesDto;
import org.springframework.stereotype.Service;

@Service
public class CurrenciesService {

    public CurrenciesDto load(String id) {
        return new CurrenciesDto(id == null ? "" : id, "input", "");
    }

    public CurrenciesDto process(CurrenciesDto dto) {
        return dto;
    }
}
