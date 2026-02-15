package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CurrencyRatesDto;
import net.sam.dcl.modern.service.CurrencyRatesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currency-rates")
public class CurrencyRatesController {

    private final CurrencyRatesService service;

    public CurrencyRatesController(CurrencyRatesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CurrencyRatesDto.empty());
        model.addAttribute("screen", "currency-rates");
        return "currency-rates";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "currency-rates");
        return "currency-rates";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CurrencyRatesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "currency-rates");
        model.addAttribute("saved", true);
        return "currency-rates";
    }
}
