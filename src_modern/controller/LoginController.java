package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.LoginDto;
import net.sam.dcl.modern.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", LoginDto.empty());
        model.addAttribute("screen", "login");
        return "login";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "login");
        return "login";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") LoginDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "login");
        model.addAttribute("saved", true);
        return "login";
    }
}
