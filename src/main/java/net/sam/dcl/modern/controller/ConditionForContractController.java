package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ConditionForContractDto;
import net.sam.dcl.modern.service.ConditionForContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/condition-for-contract")
public class ConditionForContractController {

    private final ConditionForContractService service;

    public ConditionForContractController(ConditionForContractService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ConditionForContractDto.empty());
        model.addAttribute("screen", "condition-for-contract");
        return "condition-for-contract";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "condition-for-contract");
        return "condition-for-contract";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ConditionForContractDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "condition-for-contract");
        model.addAttribute("saved", true);
        return "condition-for-contract";
    }
}
