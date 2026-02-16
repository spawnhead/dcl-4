package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.LanguagesDto;
import net.sam.dcl.modern.service.LanguagesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/languages")
public class LanguagesController {

    private final LanguagesService service;

    public LanguagesController(LanguagesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", LanguagesDto.empty());
        model.addAttribute("screen", "languages");
        return "languages";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "languages");
        return "languages";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") LanguagesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "languages");
        model.addAttribute("saved", true);
        return "languages";
    }
}
