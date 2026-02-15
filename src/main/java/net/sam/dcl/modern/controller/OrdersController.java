package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.OrdersDto;
import net.sam.dcl.modern.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService service;

    public OrdersController(OrdersService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", OrdersDto.empty());
        model.addAttribute("screen", "orders");
        return "orders";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "orders");
        return "orders";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") OrdersDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "orders");
        model.addAttribute("saved", true);
        return "orders";
    }
}
