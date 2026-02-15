package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CustomCodeDto;
import net.sam.dcl.modern.service.CustomCodeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/custom-code")
public class CustomCodeController {

    private final CustomCodeService service;

    public CustomCodeController(CustomCodeService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CustomCodeDto.empty());
        model.addAttribute("screen", "custom-code");
        return "custom-code";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "custom-code");
        return "custom-code";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CustomCodeDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "custom-code");
        model.addAttribute("saved", true);
        return "custom-code";
    }
}
