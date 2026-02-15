package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SettingDto;
import net.sam.dcl.modern.service.SettingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting")
public class SettingController {

    private final SettingService service;

    public SettingController(SettingService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SettingDto.empty());
        model.addAttribute("screen", "setting");
        return "setting";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "setting");
        return "setting";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SettingDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "setting");
        model.addAttribute("saved", true);
        return "setting";
    }
}
