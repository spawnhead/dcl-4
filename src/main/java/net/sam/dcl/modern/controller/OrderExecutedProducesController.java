package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.OrderExecutedProducesDto;
import net.sam.dcl.modern.service.OrderExecutedProducesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order-executed-produces")
public class OrderExecutedProducesController {

    private final OrderExecutedProducesService service;

    public OrderExecutedProducesController(OrderExecutedProducesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", OrderExecutedProducesDto.empty());
        model.addAttribute("screen", "order-executed-produces");
        return "order-executed-produces";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "order-executed-produces");
        return "order-executed-produces";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") OrderExecutedProducesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "order-executed-produces");
        model.addAttribute("saved", true);
        return "order-executed-produces";
    }
}
