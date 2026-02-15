package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.AdmZoneDto;
import net.sam.dcl.modern.service.AdmZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adm-zone")
public class AdmZoneController {

    private final AdmZoneService service;

    public AdmZoneController(AdmZoneService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", AdmZoneDto.empty());
        model.addAttribute("screen", "adm-zone");
        return "adm-zone";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "adm-zone");
        return "adm-zone";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") AdmZoneDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "adm-zone");
        model.addAttribute("saved", true);
        return "adm-zone";
    }
}
