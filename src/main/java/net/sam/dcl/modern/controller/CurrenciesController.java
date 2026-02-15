package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CurrenciesDto;
import net.sam.dcl.modern.service.CurrenciesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currencies")
public class CurrenciesController {

    private final CurrenciesService service;

    public CurrenciesController(CurrenciesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CurrenciesDto.empty());
        model.addAttribute("screen", "currencies");
        return "currencies";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "currencies");
        return "currencies";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CurrenciesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "currencies");
        model.addAttribute("saved", true);
        return "currencies";
    }
}
