package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ReportsDto;
import org.springframework.stereotype.Service;

@Service
public class ReportsService {

    public ReportsDto load(String id) {
        return new ReportsDto(id == null ? "" : id, "input", "");
    }

    public ReportsDto process(ReportsDto dto) {
        return dto;
    }
}
