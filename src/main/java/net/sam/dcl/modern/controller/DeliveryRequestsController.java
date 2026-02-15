package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.DeliveryRequestsDto;
import net.sam.dcl.modern.service.DeliveryRequestsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delivery-requests")
public class DeliveryRequestsController {

    private final DeliveryRequestsService service;

    public DeliveryRequestsController(DeliveryRequestsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", DeliveryRequestsDto.empty());
        model.addAttribute("screen", "delivery-requests");
        return "delivery-requests";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "delivery-requests");
        return "delivery-requests";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") DeliveryRequestsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "delivery-requests");
        model.addAttribute("saved", true);
        return "delivery-requests";
    }
}
