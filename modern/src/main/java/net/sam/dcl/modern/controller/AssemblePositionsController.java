package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.AssemblePositionsDto;
import net.sam.dcl.modern.service.AssemblePositionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assemble-positions")
public class AssemblePositionsController {

    private final AssemblePositionsService service;

    public AssemblePositionsController(AssemblePositionsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", AssemblePositionsDto.empty());
        model.addAttribute("screen", "assemble-positions");
        return "assemble-positions";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "assemble-positions");
        return "assemble-positions";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") AssemblePositionsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "assemble-positions");
        model.addAttribute("saved", true);
        return "assemble-positions";
    }
}
