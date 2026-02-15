package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CustomCodesDto;
import net.sam.dcl.modern.service.CustomCodesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/custom-codes")
public class CustomCodesController {

    private final CustomCodesService service;

    public CustomCodesController(CustomCodesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CustomCodesDto.empty());
        model.addAttribute("screen", "custom-codes");
        return "custom-codes";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "custom-codes");
        return "custom-codes";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CustomCodesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "custom-codes");
        model.addAttribute("saved", true);
        return "custom-codes";
    }
}
