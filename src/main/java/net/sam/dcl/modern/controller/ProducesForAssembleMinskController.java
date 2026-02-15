package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ProducesForAssembleMinskDto;
import net.sam.dcl.modern.service.ProducesForAssembleMinskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produces-for-assemble-minsk")
public class ProducesForAssembleMinskController {

    private final ProducesForAssembleMinskService service;

    public ProducesForAssembleMinskController(ProducesForAssembleMinskService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ProducesForAssembleMinskDto.empty());
        model.addAttribute("screen", "produces-for-assemble-minsk");
        return "produces-for-assemble-minsk";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "produces-for-assemble-minsk");
        return "produces-for-assemble-minsk";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ProducesForAssembleMinskDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "produces-for-assemble-minsk");
        model.addAttribute("saved", true);
        return "produces-for-assemble-minsk";
    }
}
