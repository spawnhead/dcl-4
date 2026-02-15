package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.FixAttachmentsDto;
import net.sam.dcl.modern.service.FixAttachmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fix-attachments")
public class FixAttachmentsController {

    private final FixAttachmentsService service;

    public FixAttachmentsController(FixAttachmentsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", FixAttachmentsDto.empty());
        model.addAttribute("screen", "fix-attachments");
        return "fix-attachments";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "fix-attachments");
        return "fix-attachments";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") FixAttachmentsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "fix-attachments");
        model.addAttribute("saved", true);
        return "fix-attachments";
    }
}
