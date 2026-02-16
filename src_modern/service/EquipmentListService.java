package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.EquipmentListDto;
import org.springframework.stereotype.Service;

@Service
public class EquipmentListService {

    public EquipmentListDto load(String id) {
        return new EquipmentListDto(id == null ? "" : id, "input", "");
    }

    public EquipmentListDto process(EquipmentListDto dto) {
        return dto;
    }
}
