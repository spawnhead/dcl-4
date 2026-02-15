package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.LanguageDto;
import net.sam.dcl.modern.service.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService service;

    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", LanguageDto.empty());
        model.addAttribute("screen", "language");
        return "language";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "language");
        return "language";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") LanguageDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "language");
        model.addAttribute("saved", true);
        return "language";
    }
}
