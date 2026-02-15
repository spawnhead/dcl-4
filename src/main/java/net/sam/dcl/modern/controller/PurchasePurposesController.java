package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.PurchasePurposesDto;
import net.sam.dcl.modern.service.PurchasePurposesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase-purposes")
public class PurchasePurposesController {

    private final PurchasePurposesService service;

    public PurchasePurposesController(PurchasePurposesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", PurchasePurposesDto.empty());
        model.addAttribute("screen", "purchase-purposes");
        return "purchase-purposes";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "purchase-purposes");
        return "purchase-purposes";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") PurchasePurposesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "purchase-purposes");
        model.addAttribute("saved", true);
        return "purchase-purposes";
    }
}
