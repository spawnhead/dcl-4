package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CalculationStateJustGridDto;
import net.sam.dcl.modern.service.CalculationStateJustGridService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculation-state-just-grid")
public class CalculationStateJustGridController {

    private final CalculationStateJustGridService service;

    public CalculationStateJustGridController(CalculationStateJustGridService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CalculationStateJustGridDto.empty());
        model.addAttribute("screen", "calculation-state-just-grid");
        return "calculation-state-just-grid";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "calculation-state-just-grid");
        return "calculation-state-just-grid";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CalculationStateJustGridDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "calculation-state-just-grid");
        model.addAttribute("saved", true);
        return "calculation-state-just-grid";
    }
}
