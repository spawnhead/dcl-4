package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ShippingDocTypesDto;
import net.sam.dcl.modern.service.ShippingDocTypesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipping-doc-types")
public class ShippingDocTypesController {

    private final ShippingDocTypesService service;

    public ShippingDocTypesController(ShippingDocTypesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ShippingDocTypesDto.empty());
        model.addAttribute("screen", "shipping-doc-types");
        return "shipping-doc-types";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "shipping-doc-types");
        return "shipping-doc-types";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ShippingDocTypesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "shipping-doc-types");
        model.addAttribute("saved", true);
        return "shipping-doc-types";
    }
}
