package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ActionRolesDto;
import net.sam.dcl.modern.service.ActionRolesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/action-roles")
public class ActionRolesController {

    private final ActionRolesService service;

    public ActionRolesController(ActionRolesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ActionRolesDto.empty());
        model.addAttribute("screen", "action-roles");
        return "action-roles";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "action-roles");
        return "action-roles";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ActionRolesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "action-roles");
        model.addAttribute("saved", true);
        return "action-roles";
    }
}
