package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.GoodsCirculationDto;
import net.sam.dcl.modern.service.GoodsCirculationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods-circulation")
public class GoodsCirculationController {

    private final GoodsCirculationService service;

    public GoodsCirculationController(GoodsCirculationService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", GoodsCirculationDto.empty());
        model.addAttribute("screen", "goods-circulation");
        return "goods-circulation";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "goods-circulation");
        return "goods-circulation";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") GoodsCirculationDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "goods-circulation");
        model.addAttribute("saved", true);
        return "goods-circulation";
    }
}
