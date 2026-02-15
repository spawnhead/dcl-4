package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CurrencyRateDto;
import net.sam.dcl.modern.service.CurrencyRateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currency-rate")
public class CurrencyRateController {

    private final CurrencyRateService service;

    public CurrencyRateController(CurrencyRateService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CurrencyRateDto.empty());
        model.addAttribute("screen", "currency-rate");
        return "currency-rate";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "currency-rate");
        return "currency-rate";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CurrencyRateDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "currency-rate");
        model.addAttribute("saved", true);
        return "currency-rate";
    }
}
