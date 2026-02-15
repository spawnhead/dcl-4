package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.UnitDto;
import net.sam.dcl.modern.service.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/unit")
public class UnitController {

    private final UnitService service;

    public UnitController(UnitService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", UnitDto.empty());
        model.addAttribute("screen", "unit");
        return "unit";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "unit");
        return "unit";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") UnitDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "unit");
        model.addAttribute("saved", true);
        return "unit";
    }
}
