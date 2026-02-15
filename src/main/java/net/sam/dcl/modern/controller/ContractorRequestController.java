package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractorRequestDto;
import net.sam.dcl.modern.service.ContractorRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contractor-request")
public class ContractorRequestController {

    private final ContractorRequestService service;

    public ContractorRequestController(ContractorRequestService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractorRequestDto.empty());
        model.addAttribute("screen", "contractor-request");
        return "contractor-request";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contractor-request");
        return "contractor-request";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractorRequestDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contractor-request");
        model.addAttribute("saved", true);
        return "contractor-request";
    }
}
