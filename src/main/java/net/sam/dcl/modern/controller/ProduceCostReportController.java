package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ProduceCostReportDto;
import net.sam.dcl.modern.service.ProduceCostReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produce-cost-report")
public class ProduceCostReportController {

    private final ProduceCostReportService service;

    public ProduceCostReportController(ProduceCostReportService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ProduceCostReportDto.empty());
        model.addAttribute("screen", "produce-cost-report");
        return "produce-cost-report";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "produce-cost-report");
        return "produce-cost-report";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ProduceCostReportDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "produce-cost-report");
        model.addAttribute("saved", true);
        return "produce-cost-report";
    }
}
