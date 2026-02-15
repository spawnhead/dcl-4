package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.SellerDto;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    public SellerDto load(String id) {
        return new SellerDto(id == null ? "" : id, "input", "");
    }

    public SellerDto process(SellerDto dto) {
        return dto;
    }
}
