package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.TimeboardWorkDto;
import net.sam.dcl.modern.service.TimeboardWorkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeboard-work")
public class TimeboardWorkController {

    private final TimeboardWorkService service;

    public TimeboardWorkController(TimeboardWorkService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", TimeboardWorkDto.empty());
        model.addAttribute("screen", "timeboard-work");
        return "timeboard-work";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "timeboard-work");
        return "timeboard-work";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") TimeboardWorkDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "timeboard-work");
        model.addAttribute("saved", true);
        return "timeboard-work";
    }
}
