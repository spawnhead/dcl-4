package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.DepartmentDto;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    public DepartmentDto load(String id) {
        return new DepartmentDto(id == null ? "" : id, "input", "");
    }

    public DepartmentDto process(DepartmentDto dto) {
        return dto;
    }
}
