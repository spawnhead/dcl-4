package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.BlanksDto;
import net.sam.dcl.modern.service.BlanksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blanks")
public class BlanksController {

    private final BlanksService service;

    public BlanksController(BlanksService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", BlanksDto.empty());
        model.addAttribute("screen", "blanks");
        return "blanks";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "blanks");
        return "blanks";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") BlanksDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "blanks");
        model.addAttribute("saved", true);
        return "blanks";
    }
}
