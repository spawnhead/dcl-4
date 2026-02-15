package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ShippingReportDto;
import net.sam.dcl.modern.service.ShippingReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipping-report")
public class ShippingReportController {

    private final ShippingReportService service;

    public ShippingReportController(ShippingReportService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ShippingReportDto.empty());
        model.addAttribute("screen", "shipping-report");
        return "shipping-report";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "shipping-report");
        return "shipping-report";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ShippingReportDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "shipping-report");
        model.addAttribute("saved", true);
        return "shipping-report";
    }
}
