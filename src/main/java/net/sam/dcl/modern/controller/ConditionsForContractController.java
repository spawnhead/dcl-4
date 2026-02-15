package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ConditionsForContractDto;
import net.sam.dcl.modern.service.ConditionsForContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conditions-for-contract")
public class ConditionsForContractController {

    private final ConditionsForContractService service;

    public ConditionsForContractController(ConditionsForContractService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ConditionsForContractDto.empty());
        model.addAttribute("screen", "conditions-for-contract");
        return "conditions-for-contract";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "conditions-for-contract");
        return "conditions-for-contract";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ConditionsForContractDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "conditions-for-contract");
        model.addAttribute("saved", true);
        return "conditions-for-contract";
    }
}
