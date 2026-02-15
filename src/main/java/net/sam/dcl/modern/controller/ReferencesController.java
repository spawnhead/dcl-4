package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ReferencesDto;
import net.sam.dcl.modern.service.ReferencesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/references")
public class ReferencesController {

    private final ReferencesService service;

    public ReferencesController(ReferencesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ReferencesDto.empty());
        model.addAttribute("screen", "references");
        return "references";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "references");
        return "references";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ReferencesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "references");
        model.addAttribute("saved", true);
        return "references";
    }
}
