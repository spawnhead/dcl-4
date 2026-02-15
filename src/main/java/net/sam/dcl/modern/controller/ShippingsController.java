package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ShippingsDto;
import net.sam.dcl.modern.service.ShippingsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shippings")
public class ShippingsController {

    private final ShippingsService service;

    public ShippingsController(ShippingsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ShippingsDto.empty());
        model.addAttribute("screen", "shippings");
        return "shippings";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "shippings");
        return "shippings";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ShippingsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "shippings");
        model.addAttribute("saved", true);
        return "shippings";
    }
}
