package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractorsListDto;
import net.sam.dcl.modern.service.ContractorsListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contractors-list")
public class ContractorsListController {

    private final ContractorsListService service;

    public ContractorsListController(ContractorsListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractorsListDto.empty());
        model.addAttribute("screen", "contractors-list");
        return "contractors-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contractors-list");
        return "contractors-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractorsListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contractors-list");
        model.addAttribute("saved", true);
        return "contractors-list";
    }
}
