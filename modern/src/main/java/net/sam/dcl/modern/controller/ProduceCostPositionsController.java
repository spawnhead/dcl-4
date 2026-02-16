package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ProduceCostPositionsDto;
import net.sam.dcl.modern.service.ProduceCostPositionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produce-cost-positions")
public class ProduceCostPositionsController {

    private final ProduceCostPositionsService service;

    public ProduceCostPositionsController(ProduceCostPositionsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ProduceCostPositionsDto.empty());
        model.addAttribute("screen", "produce-cost-positions");
        return "produce-cost-positions";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "produce-cost-positions");
        return "produce-cost-positions";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ProduceCostPositionsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "produce-cost-positions");
        model.addAttribute("saved", true);
        return "produce-cost-positions";
    }
}
