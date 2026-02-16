package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CountriesDto;
import net.sam.dcl.modern.service.CountriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/countries")
public class CountriesController {

    private final CountriesService service;

    public CountriesController(CountriesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CountriesDto.empty());
        model.addAttribute("screen", "countries");
        return "countries";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "countries");
        return "countries";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CountriesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "countries");
        model.addAttribute("saved", true);
        return "countries";
    }
}
