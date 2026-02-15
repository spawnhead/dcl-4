package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractsDto;
import net.sam.dcl.modern.service.ContractsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contracts")
public class ContractsController {

    private final ContractsService service;

    public ContractsController(ContractsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractsDto.empty());
        model.addAttribute("screen", "contracts");
        return "contracts";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contracts");
        return "contracts";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contracts");
        model.addAttribute("saved", true);
        return "contracts";
    }
}
