package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractsDepFromContractorListDto;
import net.sam.dcl.modern.service.ContractsDepFromContractorListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contracts-dep-from-contractor-list")
public class ContractsDepFromContractorListController {

    private final ContractsDepFromContractorListService service;

    public ContractsDepFromContractorListController(ContractsDepFromContractorListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractsDepFromContractorListDto.empty());
        model.addAttribute("screen", "contracts-dep-from-contractor-list");
        return "contracts-dep-from-contractor-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contracts-dep-from-contractor-list");
        return "contracts-dep-from-contractor-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractsDepFromContractorListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contracts-dep-from-contractor-list");
        model.addAttribute("saved", true);
        return "contracts-dep-from-contractor-list";
    }
}
