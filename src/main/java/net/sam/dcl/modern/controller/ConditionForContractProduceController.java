package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ConditionForContractProduceDto;
import net.sam.dcl.modern.service.ConditionForContractProduceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/condition-for-contract-produce")
public class ConditionForContractProduceController {

    private final ConditionForContractProduceService service;

    public ConditionForContractProduceController(ConditionForContractProduceService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ConditionForContractProduceDto.empty());
        model.addAttribute("screen", "condition-for-contract-produce");
        return "condition-for-contract-produce";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "condition-for-contract-produce");
        return "condition-for-contract-produce";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ConditionForContractProduceDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "condition-for-contract-produce");
        model.addAttribute("saved", true);
        return "condition-for-contract-produce";
    }
}
