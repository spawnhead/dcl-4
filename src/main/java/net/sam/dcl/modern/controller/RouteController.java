package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.RouteDto;
import net.sam.dcl.modern.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", RouteDto.empty());
        model.addAttribute("screen", "route");
        return "route";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "route");
        return "route";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") RouteDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "route");
        model.addAttribute("saved", true);
        return "route";
    }
}
