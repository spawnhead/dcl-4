package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.UsersDto;
import net.sam.dcl.modern.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", UsersDto.empty());
        model.addAttribute("screen", "users");
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "users");
        return "users";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") UsersDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "users");
        model.addAttribute("saved", true);
        return "users";
    }
}
