package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.OrdersUnexecutedDto;
import net.sam.dcl.modern.service.OrdersUnexecutedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders-unexecuted")
public class OrdersUnexecutedController {

    private final OrdersUnexecutedService service;

    public OrdersUnexecutedController(OrdersUnexecutedService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", OrdersUnexecutedDto.empty());
        model.addAttribute("screen", "orders-unexecuted");
        return "orders-unexecuted";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "orders-unexecuted");
        return "orders-unexecuted";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") OrdersUnexecutedDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "orders-unexecuted");
        model.addAttribute("saved", true);
        return "orders-unexecuted";
    }
}
