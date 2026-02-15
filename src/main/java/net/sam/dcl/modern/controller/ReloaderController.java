package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ReloaderDto;
import net.sam.dcl.modern.service.ReloaderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reloader")
public class ReloaderController {

    private final ReloaderService service;

    public ReloaderController(ReloaderService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ReloaderDto.empty());
        model.addAttribute("screen", "reloader");
        return "reloader";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "reloader");
        return "reloader";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ReloaderDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "reloader");
        model.addAttribute("saved", true);
        return "reloader";
    }
}
