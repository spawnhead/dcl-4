package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ProduceMovementDto;
import net.sam.dcl.modern.service.ProduceMovementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produce-movement")
public class ProduceMovementController {

    private final ProduceMovementService service;

    public ProduceMovementController(ProduceMovementService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ProduceMovementDto.empty());
        model.addAttribute("screen", "produce-movement");
        return "produce-movement";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "produce-movement");
        return "produce-movement";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ProduceMovementDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "produce-movement");
        model.addAttribute("saved", true);
        return "produce-movement";
    }
}
