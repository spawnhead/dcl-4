package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SpecificationDto;
import net.sam.dcl.modern.service.SpecificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specification")
public class SpecificationController {

    private final SpecificationService service;

    public SpecificationController(SpecificationService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SpecificationDto.empty());
        model.addAttribute("screen", "specification");
        return "specification";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "specification");
        return "specification";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SpecificationDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "specification");
        model.addAttribute("saved", true);
        return "specification";
    }
}
