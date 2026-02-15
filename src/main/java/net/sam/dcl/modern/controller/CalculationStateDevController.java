package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CalculationStateDevDto;
import net.sam.dcl.modern.service.CalculationStateDevService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculation-state-dev")
public class CalculationStateDevController {

    private final CalculationStateDevService service;

    public CalculationStateDevController(CalculationStateDevService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CalculationStateDevDto.empty());
        model.addAttribute("screen", "calculation-state-dev");
        return "calculation-state-dev";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "calculation-state-dev");
        return "calculation-state-dev";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CalculationStateDevDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "calculation-state-dev");
        model.addAttribute("saved", true);
        return "calculation-state-dev";
    }
}
