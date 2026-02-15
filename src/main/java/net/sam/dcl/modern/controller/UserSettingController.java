package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.UserSettingDto;
import net.sam.dcl.modern.service.UserSettingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-setting")
public class UserSettingController {

    private final UserSettingService service;

    public UserSettingController(UserSettingService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", UserSettingDto.empty());
        model.addAttribute("screen", "user-setting");
        return "user-setting";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "user-setting");
        return "user-setting";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") UserSettingDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "user-setting");
        model.addAttribute("saved", true);
        return "user-setting";
    }
}
