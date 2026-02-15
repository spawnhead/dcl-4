package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CountryDto;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public CountryDto load(String id) {
        return new CountryDto(id == null ? "" : id, "input", "");
    }

    public CountryDto process(CountryDto dto) {
        return dto;
    }
}
