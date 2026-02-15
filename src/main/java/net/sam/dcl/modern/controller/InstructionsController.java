package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.InstructionsDto;
import net.sam.dcl.modern.service.InstructionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instructions")
public class InstructionsController {

    private final InstructionsService service;

    public InstructionsController(InstructionsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", InstructionsDto.empty());
        model.addAttribute("screen", "instructions");
        return "instructions";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "instructions");
        return "instructions";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") InstructionsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "instructions");
        model.addAttribute("saved", true);
        return "instructions";
    }
}
