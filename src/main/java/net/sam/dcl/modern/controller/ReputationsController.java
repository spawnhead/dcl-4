package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ReputationsDto;
import net.sam.dcl.modern.service.ReputationsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reputations")
public class ReputationsController {

    private final ReputationsService service;

    public ReputationsController(ReputationsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ReputationsDto.empty());
        model.addAttribute("screen", "reputations");
        return "reputations";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "reputations");
        return "reputations";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ReputationsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "reputations");
        model.addAttribute("saved", true);
        return "reputations";
    }
}
