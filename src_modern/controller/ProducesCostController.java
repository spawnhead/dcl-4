package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ProducesCostDto;
import net.sam.dcl.modern.service.ProducesCostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produces-cost")
public class ProducesCostController {

    private final ProducesCostService service;

    public ProducesCostController(ProducesCostService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ProducesCostDto.empty());
        model.addAttribute("screen", "produces-cost");
        return "produces-cost";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "produces-cost");
        return "produces-cost";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ProducesCostDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "produces-cost");
        model.addAttribute("saved", true);
        return "produces-cost";
    }
}
