package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.RolesDto;
import net.sam.dcl.modern.service.RolesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RolesController {

    private final RolesService service;

    public RolesController(RolesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", RolesDto.empty());
        model.addAttribute("screen", "roles");
        return "roles";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "roles");
        return "roles";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") RolesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "roles");
        model.addAttribute("saved", true);
        return "roles";
    }
}
