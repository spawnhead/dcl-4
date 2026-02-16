package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.RoleDto;
import net.sam.dcl.modern.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", RoleDto.empty());
        model.addAttribute("screen", "role");
        return "role";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "role");
        return "role";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") RoleDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "role");
        model.addAttribute("saved", true);
        return "role";
    }
}
