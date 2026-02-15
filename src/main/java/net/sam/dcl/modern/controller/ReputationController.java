package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ReputationDto;
import net.sam.dcl.modern.service.ReputationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reputation")
public class ReputationController {

    private final ReputationService service;

    public ReputationController(ReputationService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ReputationDto.empty());
        model.addAttribute("screen", "reputation");
        return "reputation";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "reputation");
        return "reputation";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ReputationDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "reputation");
        model.addAttribute("saved", true);
        return "reputation";
    }
}
