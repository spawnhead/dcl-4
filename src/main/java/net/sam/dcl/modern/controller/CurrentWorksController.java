package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CurrentWorksDto;
import net.sam.dcl.modern.service.CurrentWorksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/current-works")
public class CurrentWorksController {

    private final CurrentWorksService service;

    public CurrentWorksController(CurrentWorksService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CurrentWorksDto.empty());
        model.addAttribute("screen", "current-works");
        return "current-works";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "current-works");
        return "current-works";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CurrentWorksDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "current-works");
        model.addAttribute("saved", true);
        return "current-works";
    }
}
