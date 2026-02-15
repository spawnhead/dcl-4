package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.PersonalOfficeDto;
import net.sam.dcl.modern.service.PersonalOfficeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal-office")
public class PersonalOfficeController {

    private final PersonalOfficeService service;

    public PersonalOfficeController(PersonalOfficeService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", PersonalOfficeDto.empty());
        model.addAttribute("screen", "personal-office");
        return "personal-office";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "personal-office");
        return "personal-office";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") PersonalOfficeDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "personal-office");
        model.addAttribute("saved", true);
        return "personal-office";
    }
}
