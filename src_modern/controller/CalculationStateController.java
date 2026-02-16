package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CalculationStateDto;
import net.sam.dcl.modern.service.CalculationStateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculation-state")
public class CalculationStateController {

    private final CalculationStateService service;

    public CalculationStateController(CalculationStateService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CalculationStateDto.empty());
        model.addAttribute("screen", "calculation-state");
        return "calculation-state";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "calculation-state");
        return "calculation-state";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CalculationStateDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "calculation-state");
        model.addAttribute("saved", true);
        return "calculation-state";
    }
}
