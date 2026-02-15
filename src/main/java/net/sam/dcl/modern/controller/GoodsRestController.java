package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.GoodsRestDto;
import net.sam.dcl.modern.service.GoodsRestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods-rest")
public class GoodsRestController {

    private final GoodsRestService service;

    public GoodsRestController(GoodsRestService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", GoodsRestDto.empty());
        model.addAttribute("screen", "goods-rest");
        return "goods-rest";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "goods-rest");
        return "goods-rest";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") GoodsRestDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "goods-rest");
        model.addAttribute("saved", true);
        return "goods-rest";
    }
}
