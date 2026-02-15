package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SpecificationsDepFromContractListDto;
import net.sam.dcl.modern.service.SpecificationsDepFromContractListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specifications-dep-from-contract-list")
public class SpecificationsDepFromContractListController {

    private final SpecificationsDepFromContractListService service;

    public SpecificationsDepFromContractListController(SpecificationsDepFromContractListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SpecificationsDepFromContractListDto.empty());
        model.addAttribute("screen", "specifications-dep-from-contract-list");
        return "specifications-dep-from-contract-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "specifications-dep-from-contract-list");
        return "specifications-dep-from-contract-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SpecificationsDepFromContractListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "specifications-dep-from-contract-list");
        model.addAttribute("saved", true);
        return "specifications-dep-from-contract-list";
    }
}
