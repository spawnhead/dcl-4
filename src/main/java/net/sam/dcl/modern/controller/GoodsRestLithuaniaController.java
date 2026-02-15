package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.GoodsRestLithuaniaDto;
import net.sam.dcl.modern.service.GoodsRestLithuaniaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods-rest-lithuania")
public class GoodsRestLithuaniaController {

    private final GoodsRestLithuaniaService service;

    public GoodsRestLithuaniaController(GoodsRestLithuaniaService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", GoodsRestLithuaniaDto.empty());
        model.addAttribute("screen", "goods-rest-lithuania");
        return "goods-rest-lithuania";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "goods-rest-lithuania");
        return "goods-rest-lithuania";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") GoodsRestLithuaniaDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "goods-rest-lithuania");
        model.addAttribute("saved", true);
        return "goods-rest-lithuania";
    }
}
