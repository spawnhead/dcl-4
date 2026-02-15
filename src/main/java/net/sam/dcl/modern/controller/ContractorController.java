package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractorDto;
import net.sam.dcl.modern.service.ContractorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contractor")
public class ContractorController {

    private final ContractorService service;

    public ContractorController(ContractorService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractorDto.empty());
        model.addAttribute("screen", "contractor");
        return "contractor";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contractor");
        return "contractor";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractorDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contractor");
        model.addAttribute("saved", true);
        return "contractor";
    }
}
