package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.RatesNdsDto;
import net.sam.dcl.modern.service.RatesNdsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rates-nds")
public class RatesNdsController {

    private final RatesNdsService service;

    public RatesNdsController(RatesNdsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", RatesNdsDto.empty());
        model.addAttribute("screen", "rates-nds");
        return "rates-nds";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "rates-nds");
        return "rates-nds";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") RatesNdsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "rates-nds");
        model.addAttribute("saved", true);
        return "rates-nds";
    }
}
