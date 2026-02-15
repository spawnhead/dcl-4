package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.DepartmentsDto;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsService {

    public DepartmentsDto load(String id) {
        return new DepartmentsDto(id == null ? "" : id, "input", "");
    }

    public DepartmentsDto process(DepartmentsDto dto) {
        return dto;
    }
}
