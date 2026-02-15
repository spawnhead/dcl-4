package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.OrderProduceDto;
import net.sam.dcl.modern.service.OrderProduceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order-produce")
public class OrderProduceController {

    private final OrderProduceService service;

    public OrderProduceController(OrderProduceService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", OrderProduceDto.empty());
        model.addAttribute("screen", "order-produce");
        return "order-produce";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "order-produce");
        return "order-produce";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") OrderProduceDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "order-produce");
        model.addAttribute("saved", true);
        return "order-produce";
    }
}
