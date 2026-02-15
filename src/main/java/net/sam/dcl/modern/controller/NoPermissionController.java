package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.NoPermissionDto;
import net.sam.dcl.modern.service.NoPermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/no-permission")
public class NoPermissionController {

    private final NoPermissionService service;

    public NoPermissionController(NoPermissionService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", NoPermissionDto.empty());
        model.addAttribute("screen", "no-permission");
        return "no-permission";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "no-permission");
        return "no-permission";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") NoPermissionDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "no-permission");
        model.addAttribute("saved", true);
        return "no-permission";
    }
}
