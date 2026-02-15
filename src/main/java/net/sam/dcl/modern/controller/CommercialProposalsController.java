package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CommercialProposalsDto;
import net.sam.dcl.modern.service.CommercialProposalsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commercial-proposals")
public class CommercialProposalsController {

    private final CommercialProposalsService service;

    public CommercialProposalsController(CommercialProposalsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CommercialProposalsDto.empty());
        model.addAttribute("screen", "commercial-proposals");
        return "commercial-proposals";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "commercial-proposals");
        return "commercial-proposals";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CommercialProposalsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "commercial-proposals");
        model.addAttribute("saved", true);
        return "commercial-proposals";
    }
}
