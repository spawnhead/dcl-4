package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ProduceCostCustomDto;
import net.sam.dcl.modern.service.ProduceCostCustomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produce-cost-custom")
public class ProduceCostCustomController {

    private final ProduceCostCustomService service;

    public ProduceCostCustomController(ProduceCostCustomService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ProduceCostCustomDto.empty());
        model.addAttribute("screen", "produce-cost-custom");
        return "produce-cost-custom";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "produce-cost-custom");
        return "produce-cost-custom";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ProduceCostCustomDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "produce-cost-custom");
        model.addAttribute("saved", true);
        return "produce-cost-custom";
    }
}
