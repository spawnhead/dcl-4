package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.TimeboardDto;
import net.sam.dcl.modern.service.TimeboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeboard")
public class TimeboardController {

    private final TimeboardService service;

    public TimeboardController(TimeboardService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", TimeboardDto.empty());
        model.addAttribute("screen", "timeboard");
        return "timeboard";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "timeboard");
        return "timeboard";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") TimeboardDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "timeboard");
        model.addAttribute("saved", true);
        return "timeboard";
    }
}
