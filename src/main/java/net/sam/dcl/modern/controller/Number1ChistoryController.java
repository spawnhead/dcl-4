package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.Number1ChistoryDto;
import net.sam.dcl.modern.service.Number1ChistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/number1-chistory")
public class Number1ChistoryController {

    private final Number1ChistoryService service;

    public Number1ChistoryController(Number1ChistoryService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", Number1ChistoryDto.empty());
        model.addAttribute("screen", "number1-chistory");
        return "number1-chistory";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "number1-chistory");
        return "number1-chistory";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") Number1ChistoryDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "number1-chistory");
        model.addAttribute("saved", true);
        return "number1-chistory";
    }
}
