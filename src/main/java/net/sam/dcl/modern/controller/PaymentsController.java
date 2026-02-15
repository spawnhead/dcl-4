package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.PaymentsDto;
import net.sam.dcl.modern.service.PaymentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payments")
public class PaymentsController {

    private final PaymentsService service;

    public PaymentsController(PaymentsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", PaymentsDto.empty());
        model.addAttribute("screen", "payments");
        return "payments";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "payments");
        return "payments";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") PaymentsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "payments");
        model.addAttribute("saved", true);
        return "payments";
    }
}
