package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.MarginDevDto;
import net.sam.dcl.modern.service.MarginDevService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/margin-dev")
public class MarginDevController {

    private final MarginDevService service;

    public MarginDevController(MarginDevService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", MarginDevDto.empty());
        model.addAttribute("screen", "margin-dev");
        return "margin-dev";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "margin-dev");
        return "margin-dev";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") MarginDevDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "margin-dev");
        model.addAttribute("saved", true);
        return "margin-dev";
    }
}
