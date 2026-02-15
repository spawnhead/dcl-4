package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.LogsDto;
import net.sam.dcl.modern.service.LogsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logs")
public class LogsController {

    private final LogsService service;

    public LogsController(LogsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", LogsDto.empty());
        model.addAttribute("screen", "logs");
        return "logs";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "logs");
        return "logs";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") LogsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "logs");
        model.addAttribute("saved", true);
        return "logs";
    }
}
