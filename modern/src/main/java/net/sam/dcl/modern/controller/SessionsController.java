package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SessionsDto;
import net.sam.dcl.modern.service.SessionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sessions")
public class SessionsController {

    private final SessionsService service;

    public SessionsController(SessionsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SessionsDto.empty());
        model.addAttribute("screen", "sessions");
        return "sessions";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "sessions");
        return "sessions";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SessionsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "sessions");
        model.addAttribute("saved", true);
        return "sessions";
    }
}
