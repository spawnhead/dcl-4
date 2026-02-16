package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ReportsDto;
import net.sam.dcl.modern.service.ReportsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    private final ReportsService service;

    public ReportsController(ReportsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ReportsDto.empty());
        model.addAttribute("screen", "reports");
        return "reports";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "reports");
        return "reports";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ReportsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "reports");
        model.addAttribute("saved", true);
        return "reports";
    }
}
