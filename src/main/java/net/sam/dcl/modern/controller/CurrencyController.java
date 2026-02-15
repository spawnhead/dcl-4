package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CurrencyDto;
import net.sam.dcl.modern.service.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CurrencyDto.empty());
        model.addAttribute("screen", "currency");
        return "currency";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "currency");
        return "currency";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CurrencyDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "currency");
        model.addAttribute("saved", true);
        return "currency";
    }
}
