package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.BlankDto;
import net.sam.dcl.modern.service.BlankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blank")
public class BlankController {

    private final BlankService service;

    public BlankController(BlankService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", BlankDto.empty());
        model.addAttribute("screen", "blank");
        return "blank";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "blank");
        return "blank";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") BlankDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "blank");
        model.addAttribute("saved", true);
        return "blank";
    }
}
