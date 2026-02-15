package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.DevZoneDto;
import net.sam.dcl.modern.service.DevZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev-zone")
public class DevZoneController {

    private final DevZoneService service;

    public DevZoneController(DevZoneService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", DevZoneDto.empty());
        model.addAttribute("screen", "dev-zone");
        return "dev-zone";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "dev-zone");
        return "dev-zone";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") DevZoneDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "dev-zone");
        model.addAttribute("saved", true);
        return "dev-zone";
    }
}
