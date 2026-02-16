package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.UserRolesDto;
import net.sam.dcl.modern.service.UserRolesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-roles")
public class UserRolesController {

    private final UserRolesService service;

    public UserRolesController(UserRolesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", UserRolesDto.empty());
        model.addAttribute("screen", "user-roles");
        return "user-roles";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "user-roles");
        return "user-roles";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") UserRolesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "user-roles");
        model.addAttribute("saved", true);
        return "user-roles";
    }
}
