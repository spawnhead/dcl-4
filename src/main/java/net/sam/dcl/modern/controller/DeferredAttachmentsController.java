package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.DeferredAttachmentsDto;
import net.sam.dcl.modern.service.DeferredAttachmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deferred-attachments")
public class DeferredAttachmentsController {

    private final DeferredAttachmentsService service;

    public DeferredAttachmentsController(DeferredAttachmentsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", DeferredAttachmentsDto.empty());
        model.addAttribute("screen", "deferred-attachments");
        return "deferred-attachments";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "deferred-attachments");
        return "deferred-attachments";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") DeferredAttachmentsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "deferred-attachments");
        model.addAttribute("saved", true);
        return "deferred-attachments";
    }
}
