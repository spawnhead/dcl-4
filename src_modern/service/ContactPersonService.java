package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContactPersonDto;
import org.springframework.stereotype.Service;

@Service
public class ContactPersonService {

    public ContactPersonDto load(String id) {
        return new ContactPersonDto(id == null ? "" : id, "input", "");
    }

    public ContactPersonDto process(ContactPersonDto dto) {
        return dto;
    }
}
