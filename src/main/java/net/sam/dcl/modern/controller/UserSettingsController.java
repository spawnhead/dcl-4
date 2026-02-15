package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.UserSettingsDto;
import net.sam.dcl.modern.service.UserSettingsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-settings")
public class UserSettingsController {

    private final UserSettingsService service;

    public UserSettingsController(UserSettingsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", UserSettingsDto.empty());
        model.addAttribute("screen", "user-settings");
        return "user-settings";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "user-settings");
        return "user-settings";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") UserSettingsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "user-settings");
        model.addAttribute("saved", true);
        return "user-settings";
    }
}
