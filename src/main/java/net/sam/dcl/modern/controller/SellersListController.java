package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SellersListDto;
import net.sam.dcl.modern.service.SellersListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sellers-list")
public class SellersListController {

    private final SellersListService service;

    public SellersListController(SellersListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SellersListDto.empty());
        model.addAttribute("screen", "sellers-list");
        return "sellers-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "sellers-list");
        return "sellers-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SellersListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "sellers-list");
        model.addAttribute("saved", true);
        return "sellers-list";
    }
}
