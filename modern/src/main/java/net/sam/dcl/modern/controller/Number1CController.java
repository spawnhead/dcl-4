package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.Number1CDto;
import net.sam.dcl.modern.service.Number1CService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/number1-c")
public class Number1CController {

    private final Number1CService service;

    public Number1CController(Number1CService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", Number1CDto.empty());
        model.addAttribute("screen", "number1-c");
        return "number1-c";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "number1-c");
        return "number1-c";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") Number1CDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "number1-c");
        model.addAttribute("saved", true);
        return "number1-c";
    }
}
