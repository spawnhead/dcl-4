package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.PersonalOfficeDto;
import org.springframework.stereotype.Service;

@Service
public class PersonalOfficeService {

    public PersonalOfficeDto load(String id) {
        return new PersonalOfficeDto(id == null ? "" : id, "input", "");
    }

    public PersonalOfficeDto process(PersonalOfficeDto dto) {
        return dto;
    }
}
