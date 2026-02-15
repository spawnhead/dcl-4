package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CountryDto;
import net.sam.dcl.modern.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/country")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CountryDto.empty());
        model.addAttribute("screen", "country");
        return "country";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "country");
        return "country";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CountryDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "country");
        model.addAttribute("saved", true);
        return "country";
    }
}
