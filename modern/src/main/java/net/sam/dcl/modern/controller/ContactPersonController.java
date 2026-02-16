package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContactPersonDto;
import net.sam.dcl.modern.service.ContactPersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact-person")
public class ContactPersonController {

    private final ContactPersonService service;

    public ContactPersonController(ContactPersonService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContactPersonDto.empty());
        model.addAttribute("screen", "contact-person");
        return "contact-person";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contact-person");
        return "contact-person";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContactPersonDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contact-person");
        model.addAttribute("saved", true);
        return "contact-person";
    }
}
