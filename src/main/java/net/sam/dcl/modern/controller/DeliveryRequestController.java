package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.DeliveryRequestDto;
import net.sam.dcl.modern.service.DeliveryRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delivery-request")
public class DeliveryRequestController {

    private final DeliveryRequestService service;

    public DeliveryRequestController(DeliveryRequestService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", DeliveryRequestDto.empty());
        model.addAttribute("screen", "delivery-request");
        return "delivery-request";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "delivery-request");
        return "delivery-request";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") DeliveryRequestDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "delivery-request");
        model.addAttribute("saved", true);
        return "delivery-request";
    }
}
