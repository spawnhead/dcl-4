package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.InstructionTypeDto;
import net.sam.dcl.modern.service.InstructionTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instruction-type")
public class InstructionTypeController {

    private final InstructionTypeService service;

    public InstructionTypeController(InstructionTypeService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", InstructionTypeDto.empty());
        model.addAttribute("screen", "instruction-type");
        return "instruction-type";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "instruction-type");
        return "instruction-type";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") InstructionTypeDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "instruction-type");
        model.addAttribute("saved", true);
        return "instruction-type";
    }
}
