package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ActionsDto;
import net.sam.dcl.modern.service.ActionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actions")
public class ActionsController {

    private final ActionsService service;

    public ActionsController(ActionsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ActionsDto.empty());
        model.addAttribute("screen", "actions");
        return "actions";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "actions");
        return "actions";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ActionsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "actions");
        model.addAttribute("saved", true);
        return "actions";
    }
}
