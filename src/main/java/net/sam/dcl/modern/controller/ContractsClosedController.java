package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractsClosedDto;
import net.sam.dcl.modern.service.ContractsClosedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contracts-closed")
public class ContractsClosedController {

    private final ContractsClosedService service;

    public ContractsClosedController(ContractsClosedService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractsClosedDto.empty());
        model.addAttribute("screen", "contracts-closed");
        return "contracts-closed";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contracts-closed");
        return "contracts-closed";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractsClosedDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contracts-closed");
        model.addAttribute("saved", true);
        return "contracts-closed";
    }
}
