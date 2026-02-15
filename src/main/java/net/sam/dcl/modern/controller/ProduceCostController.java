package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ProduceCostDto;
import net.sam.dcl.modern.service.ProduceCostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produce-cost")
public class ProduceCostController {

    private final ProduceCostService service;

    public ProduceCostController(ProduceCostService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ProduceCostDto.empty());
        model.addAttribute("screen", "produce-cost");
        return "produce-cost";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "produce-cost");
        return "produce-cost";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ProduceCostDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "produce-cost");
        model.addAttribute("saved", true);
        return "produce-cost";
    }
}
