package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SellersDto;
import net.sam.dcl.modern.service.SellersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sellers")
public class SellersController {

    private final SellersService service;

    public SellersController(SellersService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SellersDto.empty());
        model.addAttribute("screen", "sellers");
        return "sellers";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "sellers");
        return "sellers";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SellersDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "sellers");
        model.addAttribute("saved", true);
        return "sellers";
    }
}
