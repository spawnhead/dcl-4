package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.LoginDisabledDto;
import net.sam.dcl.modern.service.LoginDisabledService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login-disabled")
public class LoginDisabledController {

    private final LoginDisabledService service;

    public LoginDisabledController(LoginDisabledService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", LoginDisabledDto.empty());
        model.addAttribute("screen", "login-disabled");
        return "login-disabled";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "login-disabled");
        return "login-disabled";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") LoginDisabledDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "login-disabled");
        model.addAttribute("saved", true);
        return "login-disabled";
    }
}
