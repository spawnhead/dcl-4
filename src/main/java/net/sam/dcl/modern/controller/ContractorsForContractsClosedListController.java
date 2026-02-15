package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractorsForContractsClosedListDto;
import net.sam.dcl.modern.service.ContractorsForContractsClosedListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contractors-for-contracts-closed-list")
public class ContractorsForContractsClosedListController {

    private final ContractorsForContractsClosedListService service;

    public ContractorsForContractsClosedListController(ContractorsForContractsClosedListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractorsForContractsClosedListDto.empty());
        model.addAttribute("screen", "contractors-for-contracts-closed-list");
        return "contractors-for-contracts-closed-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contractors-for-contracts-closed-list");
        return "contractors-for-contracts-closed-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractorsForContractsClosedListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contractors-for-contracts-closed-list");
        model.addAttribute("saved", true);
        return "contractors-for-contracts-closed-list";
    }
}
