package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.OutgoingLettersDto;
import net.sam.dcl.modern.service.OutgoingLettersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/outgoing-letters")
public class OutgoingLettersController {

    private final OutgoingLettersService service;

    public OutgoingLettersController(OutgoingLettersService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", OutgoingLettersDto.empty());
        model.addAttribute("screen", "outgoing-letters");
        return "outgoing-letters";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "outgoing-letters");
        return "outgoing-letters";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") OutgoingLettersDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "outgoing-letters");
        model.addAttribute("saved", true);
        return "outgoing-letters";
    }
}
