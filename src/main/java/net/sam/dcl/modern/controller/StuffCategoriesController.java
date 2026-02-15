package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.StuffCategoriesDto;
import net.sam.dcl.modern.service.StuffCategoriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stuff-categories")
public class StuffCategoriesController {

    private final StuffCategoriesService service;

    public StuffCategoriesController(StuffCategoriesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", StuffCategoriesDto.empty());
        model.addAttribute("screen", "stuff-categories");
        return "stuff-categories";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "stuff-categories");
        return "stuff-categories";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") StuffCategoriesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "stuff-categories");
        model.addAttribute("saved", true);
        return "stuff-categories";
    }
}
