package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.OrdersLogisticsDto;
import net.sam.dcl.modern.service.OrdersLogisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders-logistics")
public class OrdersLogisticsController {

    private final OrdersLogisticsService service;

    public OrdersLogisticsController(OrdersLogisticsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", OrdersLogisticsDto.empty());
        model.addAttribute("screen", "orders-logistics");
        return "orders-logistics";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "orders-logistics");
        return "orders-logistics";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") OrdersLogisticsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "orders-logistics");
        model.addAttribute("saved", true);
        return "orders-logistics";
    }
}
