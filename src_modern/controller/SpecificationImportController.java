package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SpecificationImportDto;
import net.sam.dcl.modern.service.SpecificationImportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specification-import")
public class SpecificationImportController {

    private final SpecificationImportService service;

    public SpecificationImportController(SpecificationImportService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SpecificationImportDto.empty());
        model.addAttribute("screen", "specification-import");
        return "specification-import";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "specification-import");
        return "specification-import";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SpecificationImportDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "specification-import");
        model.addAttribute("saved", true);
        return "specification-import";
    }
}
