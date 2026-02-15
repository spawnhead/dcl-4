package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SpecificationImportPositionsDto;
import net.sam.dcl.modern.service.SpecificationImportPositionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specification-import-positions")
public class SpecificationImportPositionsController {

    private final SpecificationImportPositionsService service;

    public SpecificationImportPositionsController(SpecificationImportPositionsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SpecificationImportPositionsDto.empty());
        model.addAttribute("screen", "specification-import-positions");
        return "specification-import-positions";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "specification-import-positions");
        return "specification-import-positions";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SpecificationImportPositionsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "specification-import-positions");
        model.addAttribute("saved", true);
        return "specification-import-positions";
    }
}
