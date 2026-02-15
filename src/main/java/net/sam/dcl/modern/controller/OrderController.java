package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.OrderDto;
import net.sam.dcl.modern.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", OrderDto.empty());
        model.addAttribute("screen", "order");
        return "order";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "order");
        return "order";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") OrderDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "order");
        model.addAttribute("saved", true);
        return "order";
    }
}
