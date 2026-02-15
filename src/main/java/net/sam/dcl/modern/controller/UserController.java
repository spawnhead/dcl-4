package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.UserDto;
import net.sam.dcl.modern.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", UserDto.empty());
        model.addAttribute("screen", "user");
        return "user";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "user");
        return "user";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") UserDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "user");
        model.addAttribute("saved", true);
        return "user";
    }
}
