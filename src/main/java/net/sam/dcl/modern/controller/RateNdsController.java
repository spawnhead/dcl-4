package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.RateNdsDto;
import net.sam.dcl.modern.service.RateNdsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rate-nds")
public class RateNdsController {

    private final RateNdsService service;

    public RateNdsController(RateNdsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", RateNdsDto.empty());
        model.addAttribute("screen", "rate-nds");
        return "rate-nds";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "rate-nds");
        return "rate-nds";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") RateNdsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "rate-nds");
        model.addAttribute("saved", true);
        return "rate-nds";
    }
}
