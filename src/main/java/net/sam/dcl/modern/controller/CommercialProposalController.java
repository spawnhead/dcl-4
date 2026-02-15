package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CommercialProposalDto;
import net.sam.dcl.modern.service.CommercialProposalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commercial-proposal")
public class CommercialProposalController {

    private final CommercialProposalService service;

    public CommercialProposalController(CommercialProposalService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CommercialProposalDto.empty());
        model.addAttribute("screen", "commercial-proposal");
        return "commercial-proposal";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "commercial-proposal");
        return "commercial-proposal";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CommercialProposalDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "commercial-proposal");
        model.addAttribute("saved", true);
        return "commercial-proposal";
    }
}
