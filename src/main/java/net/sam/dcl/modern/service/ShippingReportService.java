package net.sam.dcl.modern.service;

import net.sam.dcl.modern.dto.ShippingReportDto;
import org.springframework.stereotype.Service;

@Service
public class ShippingReportService {

    public ShippingReportDto load(String id) {
        return new ShippingReportDto(id == null ? "" : id, "input", "");
    }

    public ShippingReportDto process(ShippingReportDto dto) {
        return dto;
    }
}
