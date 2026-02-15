package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.AttachmentsDto;
import net.sam.dcl.modern.service.AttachmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/attachments")
public class AttachmentsController {

    private final AttachmentsService service;

    public AttachmentsController(AttachmentsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", AttachmentsDto.empty());
        model.addAttribute("screen", "attachments");
        return "attachments";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "attachments");
        return "attachments";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") AttachmentsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "attachments");
        model.addAttribute("saved", true);
        return "attachments";
    }
}
