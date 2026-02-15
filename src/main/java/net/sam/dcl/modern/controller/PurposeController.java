package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.PurposeDto;
import net.sam.dcl.modern.service.PurposeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purpose")
public class PurposeController {

    private final PurposeService service;

    public PurposeController(PurposeService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", PurposeDto.empty());
        model.addAttribute("screen", "purpose");
        return "purpose";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "purpose");
        return "purpose";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") PurposeDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "purpose");
        model.addAttribute("saved", true);
        return "purpose";
    }
}
