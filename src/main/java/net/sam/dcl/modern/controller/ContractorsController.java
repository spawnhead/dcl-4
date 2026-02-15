package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractorsDto;
import net.sam.dcl.modern.service.ContractorsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contractors")
public class ContractorsController {

    private final ContractorsService service;

    public ContractorsController(ContractorsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractorsDto.empty());
        model.addAttribute("screen", "contractors");
        return "contractors";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contractors");
        return "contractors";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractorsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contractors");
        model.addAttribute("saved", true);
        return "contractors";
    }
}
