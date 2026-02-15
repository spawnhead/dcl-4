package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.PurchasePurposeDto;
import net.sam.dcl.modern.service.PurchasePurposeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase-purpose")
public class PurchasePurposeController {

    private final PurchasePurposeService service;

    public PurchasePurposeController(PurchasePurposeService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", PurchasePurposeDto.empty());
        model.addAttribute("screen", "purchase-purpose");
        return "purchase-purpose";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "purchase-purpose");
        return "purchase-purpose";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") PurchasePurposeDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "purchase-purpose");
        model.addAttribute("saved", true);
        return "purchase-purpose";
    }
}
