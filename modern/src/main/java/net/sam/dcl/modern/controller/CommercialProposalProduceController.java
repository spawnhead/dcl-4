package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CommercialProposalProduceDto;
import net.sam.dcl.modern.service.CommercialProposalProduceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commercial-proposal-produce")
public class CommercialProposalProduceController {

    private final CommercialProposalProduceService service;

    public CommercialProposalProduceController(CommercialProposalProduceService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CommercialProposalProduceDto.empty());
        model.addAttribute("screen", "commercial-proposal-produce");
        return "commercial-proposal-produce";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "commercial-proposal-produce");
        return "commercial-proposal-produce";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CommercialProposalProduceDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "commercial-proposal-produce");
        model.addAttribute("saved", true);
        return "commercial-proposal-produce";
    }
}
