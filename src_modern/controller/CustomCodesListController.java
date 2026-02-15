package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CustomCodesListDto;
import net.sam.dcl.modern.service.CustomCodesListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/custom-codes-list")
public class CustomCodesListController {

    private final CustomCodesListService service;

    public CustomCodesListController(CustomCodesListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CustomCodesListDto.empty());
        model.addAttribute("screen", "custom-codes-list");
        return "custom-codes-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "custom-codes-list");
        return "custom-codes-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CustomCodesListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "custom-codes-list");
        model.addAttribute("saved", true);
        return "custom-codes-list";
    }
}
