package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.UnitsDto;
import net.sam.dcl.modern.service.UnitsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/units")
public class UnitsController {

    private final UnitsService service;

    public UnitsController(UnitsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", UnitsDto.empty());
        model.addAttribute("screen", "units");
        return "units";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "units");
        return "units";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") UnitsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "units");
        model.addAttribute("saved", true);
        return "units";
    }
}
