package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.GoodsRestInMinskDto;
import net.sam.dcl.modern.service.GoodsRestInMinskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods-rest-in-minsk")
public class GoodsRestInMinskController {

    private final GoodsRestInMinskService service;

    public GoodsRestInMinskController(GoodsRestInMinskService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", GoodsRestInMinskDto.empty());
        model.addAttribute("screen", "goods-rest-in-minsk");
        return "goods-rest-in-minsk";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "goods-rest-in-minsk");
        return "goods-rest-in-minsk";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") GoodsRestInMinskDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "goods-rest-in-minsk");
        model.addAttribute("saved", true);
        return "goods-rest-in-minsk";
    }
}
