package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CustomCodeHistoryDto;
import net.sam.dcl.modern.service.CustomCodeHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/custom-code-history")
public class CustomCodeHistoryController {

    private final CustomCodeHistoryService service;

    public CustomCodeHistoryController(CustomCodeHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", CustomCodeHistoryDto.empty());
        model.addAttribute("screen", "custom-code-history");
        return "custom-code-history";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "custom-code-history");
        return "custom-code-history";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") CustomCodeHistoryDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "custom-code-history");
        model.addAttribute("saved", true);
        return "custom-code-history";
    }
}
