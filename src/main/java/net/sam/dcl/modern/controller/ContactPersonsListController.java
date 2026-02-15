package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContactPersonsListDto;
import net.sam.dcl.modern.service.ContactPersonsListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact-persons-list")
public class ContactPersonsListController {

    private final ContactPersonsListService service;

    public ContactPersonsListController(ContactPersonsListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContactPersonsListDto.empty());
        model.addAttribute("screen", "contact-persons-list");
        return "contact-persons-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contact-persons-list");
        return "contact-persons-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContactPersonsListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contact-persons-list");
        model.addAttribute("saved", true);
        return "contact-persons-list";
    }
}
