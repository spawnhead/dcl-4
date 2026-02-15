package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SellerDto;
import net.sam.dcl.modern.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {

    private final SellerService service;

    public SellerController(SellerService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SellerDto.empty());
        model.addAttribute("screen", "seller");
        return "seller";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "seller");
        return "seller";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SellerDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "seller");
        model.addAttribute("saved", true);
        return "seller";
    }
}
