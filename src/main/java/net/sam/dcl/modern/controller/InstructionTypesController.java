package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.InstructionTypesDto;
import net.sam.dcl.modern.service.InstructionTypesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instruction-types")
public class InstructionTypesController {

    private final InstructionTypesService service;

    public InstructionTypesController(InstructionTypesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", InstructionTypesDto.empty());
        model.addAttribute("screen", "instruction-types");
        return "instruction-types";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "instruction-types");
        return "instruction-types";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") InstructionTypesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "instruction-types");
        model.addAttribute("saved", true);
        return "instruction-types";
    }
}
