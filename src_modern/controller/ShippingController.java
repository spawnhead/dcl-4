package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ShippingDto;
import net.sam.dcl.modern.service.ShippingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingService service;

    public ShippingController(ShippingService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ShippingDto.empty());
        model.addAttribute("screen", "shipping");
        return "shipping";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "shipping");
        return "shipping";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ShippingDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "shipping");
        model.addAttribute("saved", true);
        return "shipping";
    }
}
