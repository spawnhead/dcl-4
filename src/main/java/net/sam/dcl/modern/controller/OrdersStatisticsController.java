package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.OrdersStatisticsDto;
import net.sam.dcl.modern.service.OrdersStatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders-statistics")
public class OrdersStatisticsController {

    private final OrdersStatisticsService service;

    public OrdersStatisticsController(OrdersStatisticsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", OrdersStatisticsDto.empty());
        model.addAttribute("screen", "orders-statistics");
        return "orders-statistics";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "orders-statistics");
        return "orders-statistics";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") OrdersStatisticsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "orders-statistics");
        model.addAttribute("saved", true);
        return "orders-statistics";
    }
}
