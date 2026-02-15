package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.JournalsDto;
import net.sam.dcl.modern.service.JournalsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/journals")
public class JournalsController {

    private final JournalsService service;

    public JournalsController(JournalsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", JournalsDto.empty());
        model.addAttribute("screen", "journals");
        return "journals";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "journals");
        return "journals";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") JournalsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "journals");
        model.addAttribute("saved", true);
        return "journals";
    }
}
