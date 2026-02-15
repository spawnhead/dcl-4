package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.InvitationDto;
import net.sam.dcl.modern.service.InvitationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invitation")
public class InvitationController {

    private final InvitationService service;

    public InvitationController(InvitationService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", InvitationDto.empty());
        model.addAttribute("screen", "invitation");
        return "invitation";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "invitation");
        return "invitation";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") InvitationDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "invitation");
        model.addAttribute("saved", true);
        return "invitation";
    }
}
