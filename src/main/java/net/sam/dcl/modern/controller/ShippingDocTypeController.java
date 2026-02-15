package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ShippingDocTypeDto;
import net.sam.dcl.modern.service.ShippingDocTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipping-doc-type")
public class ShippingDocTypeController {

    private final ShippingDocTypeService service;

    public ShippingDocTypeController(ShippingDocTypeService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ShippingDocTypeDto.empty());
        model.addAttribute("screen", "shipping-doc-type");
        return "shipping-doc-type";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "shipping-doc-type");
        return "shipping-doc-type";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ShippingDocTypeDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "shipping-doc-type");
        model.addAttribute("saved", true);
        return "shipping-doc-type";
    }
}
