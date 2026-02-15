package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ProduceCostProduceDto;
import net.sam.dcl.modern.service.ProduceCostProduceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produce-cost-produce")
public class ProduceCostProduceController {

    private final ProduceCostProduceService service;

    public ProduceCostProduceController(ProduceCostProduceService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ProduceCostProduceDto.empty());
        model.addAttribute("screen", "produce-cost-produce");
        return "produce-cost-produce";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "produce-cost-produce");
        return "produce-cost-produce";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ProduceCostProduceDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "produce-cost-produce");
        model.addAttribute("saved", true);
        return "produce-cost-produce";
    }
}
