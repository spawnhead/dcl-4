package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.CountriesDto;
import org.springframework.stereotype.Service;

@Service
public class CountriesService {

    public CountriesDto load(String id) {
        return new CountriesDto(id == null ? "" : id, "input", "");
    }

    public CountriesDto process(CountriesDto dto) {
        return dto;
    }
}
