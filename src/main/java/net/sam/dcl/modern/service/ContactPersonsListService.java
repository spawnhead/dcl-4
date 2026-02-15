package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ContactPersonsListDto;
import org.springframework.stereotype.Service;

@Service
public class ContactPersonsListService {

    public ContactPersonsListDto load(String id) {
        return new ContactPersonsListDto(id == null ? "" : id, "input", "");
    }

    public ContactPersonsListDto process(ContactPersonsListDto dto) {
        return dto;
    }
}
