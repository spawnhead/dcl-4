package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.OutgoingLetterDto;
import net.sam.dcl.modern.service.OutgoingLetterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/outgoing-letter")
public class OutgoingLetterController {

    private final OutgoingLetterService service;

    public OutgoingLetterController(OutgoingLetterService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", OutgoingLetterDto.empty());
        model.addAttribute("screen", "outgoing-letter");
        return "outgoing-letter";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "outgoing-letter");
        return "outgoing-letter";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") OutgoingLetterDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "outgoing-letter");
        model.addAttribute("saved", true);
        return "outgoing-letter";
    }
}
