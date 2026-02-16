package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SellersListDto;
import org.springframework.stereotype.Service;

@Service
public class SellersListService {

    public SellersListDto load(String id) {
        return new SellersListDto(id == null ? "" : id, "input", "");
    }

    public SellersListDto process(SellersListDto dto) {
        return dto;
    }
}
