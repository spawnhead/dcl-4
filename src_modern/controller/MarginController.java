package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.MarginDto;
import net.sam.dcl.modern.service.MarginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/margin")
public class MarginController {

    private final MarginService service;

    public MarginController(MarginService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", MarginDto.empty());
        model.addAttribute("screen", "margin");
        return "margin";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "margin");
        return "margin";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") MarginDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "margin");
        model.addAttribute("saved", true);
        return "margin";
    }
}
