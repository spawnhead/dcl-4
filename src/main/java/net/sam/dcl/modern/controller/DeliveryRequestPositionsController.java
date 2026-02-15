package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.DeliveryRequestPositionsDto;
import net.sam.dcl.modern.service.DeliveryRequestPositionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delivery-request-positions")
public class DeliveryRequestPositionsController {

    private final DeliveryRequestPositionsService service;

    public DeliveryRequestPositionsController(DeliveryRequestPositionsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", DeliveryRequestPositionsDto.empty());
        model.addAttribute("screen", "delivery-request-positions");
        return "delivery-request-positions";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "delivery-request-positions");
        return "delivery-request-positions";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") DeliveryRequestPositionsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "delivery-request-positions");
        model.addAttribute("saved", true);
        return "delivery-request-positions";
    }
}
