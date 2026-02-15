package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.PaymentDto;
import net.sam.dcl.modern.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", PaymentDto.empty());
        model.addAttribute("screen", "payment");
        return "payment";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "payment");
        return "payment";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") PaymentDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "payment");
        model.addAttribute("saved", true);
        return "payment";
    }
}
