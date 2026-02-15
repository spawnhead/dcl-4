package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.PurposesDto;
import net.sam.dcl.modern.service.PurposesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purposes")
public class PurposesController {

    private final PurposesService service;

    public PurposesController(PurposesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", PurposesDto.empty());
        model.addAttribute("screen", "purposes");
        return "purposes";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "purposes");
        return "purposes";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") PurposesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "purposes");
        model.addAttribute("saved", true);
        return "purposes";
    }
}
