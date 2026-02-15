package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractorRequestsDto;
import net.sam.dcl.modern.service.ContractorRequestsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contractor-requests")
public class ContractorRequestsController {

    private final ContractorRequestsService service;

    public ContractorRequestsController(ContractorRequestsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractorRequestsDto.empty());
        model.addAttribute("screen", "contractor-requests");
        return "contractor-requests";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contractor-requests");
        return "contractor-requests";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractorRequestsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contractor-requests");
        model.addAttribute("saved", true);
        return "contractor-requests";
    }
}
