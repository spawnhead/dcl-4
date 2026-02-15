package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ProduceCostReportDto;
import org.springframework.stereotype.Service;

@Service
public class ProduceCostReportService {

    public ProduceCostReportDto load(String id) {
        return new ProduceCostReportDto(id == null ? "" : id, "input", "");
    }

    public ProduceCostReportDto process(ProduceCostReportDto dto) {
        return dto;
    }
}
