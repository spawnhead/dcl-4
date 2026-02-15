package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SpecificationImportsDto;
import net.sam.dcl.modern.service.SpecificationImportsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specification-imports")
public class SpecificationImportsController {

    private final SpecificationImportsService service;

    public SpecificationImportsController(SpecificationImportsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SpecificationImportsDto.empty());
        model.addAttribute("screen", "specification-imports");
        return "specification-imports";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "specification-imports");
        return "specification-imports";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SpecificationImportsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "specification-imports");
        model.addAttribute("saved", true);
        return "specification-imports";
    }
}
