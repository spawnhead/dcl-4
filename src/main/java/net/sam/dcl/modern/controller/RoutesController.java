package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.RoutesDto;
import net.sam.dcl.modern.service.RoutesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RoutesController {

    private final RoutesService service;

    public RoutesController(RoutesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", RoutesDto.empty());
        model.addAttribute("screen", "routes");
        return "routes";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "routes");
        return "routes";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") RoutesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "routes");
        model.addAttribute("saved", true);
        return "routes";
    }
}
