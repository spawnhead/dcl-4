package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.PaySumDto;
import net.sam.dcl.modern.service.PaySumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pay-sum")
public class PaySumController {

    private final PaySumService service;

    public PaySumController(PaySumService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", PaySumDto.empty());
        model.addAttribute("screen", "pay-sum");
        return "pay-sum";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "pay-sum");
        return "pay-sum";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") PaySumDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "pay-sum");
        model.addAttribute("saved", true);
        return "pay-sum";
    }
}
