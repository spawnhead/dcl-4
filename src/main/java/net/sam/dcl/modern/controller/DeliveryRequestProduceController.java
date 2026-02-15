package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.DeliveryRequestProduceDto;
import net.sam.dcl.modern.service.DeliveryRequestProduceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delivery-request-produce")
public class DeliveryRequestProduceController {

    private final DeliveryRequestProduceService service;

    public DeliveryRequestProduceController(DeliveryRequestProduceService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", DeliveryRequestProduceDto.empty());
        model.addAttribute("screen", "delivery-request-produce");
        return "delivery-request-produce";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "delivery-request-produce");
        return "delivery-request-produce";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") DeliveryRequestProduceDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "delivery-request-produce");
        model.addAttribute("saved", true);
        return "delivery-request-produce";
    }
}
