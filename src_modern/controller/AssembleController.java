package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.AssembleDto;
import net.sam.dcl.modern.service.AssembleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assemble")
public class AssembleController {

    private final AssembleService service;

    public AssembleController(AssembleService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", AssembleDto.empty());
        model.addAttribute("screen", "assemble");
        return "assemble";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "assemble");
        return "assemble";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") AssembleDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "assemble");
        model.addAttribute("saved", true);
        return "assemble";
    }
}
