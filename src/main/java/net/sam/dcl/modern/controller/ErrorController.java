package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ErrorDto;
import net.sam.dcl.modern.service.ErrorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    private final ErrorService service;

    public ErrorController(ErrorService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ErrorDto.empty());
        model.addAttribute("screen", "error");
        return "error";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "error");
        return "error";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ErrorDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "error");
        model.addAttribute("saved", true);
        return "error";
    }
}
