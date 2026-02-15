package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ShippingPositionsDto;
import net.sam.dcl.modern.service.ShippingPositionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipping-positions")
public class ShippingPositionsController {

    private final ShippingPositionsService service;

    public ShippingPositionsController(ShippingPositionsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ShippingPositionsDto.empty());
        model.addAttribute("screen", "shipping-positions");
        return "shipping-positions";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "shipping-positions");
        return "shipping-positions";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ShippingPositionsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "shipping-positions");
        model.addAttribute("saved", true);
        return "shipping-positions";
    }
}
