package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.AssemblesDto;
import net.sam.dcl.modern.service.AssemblesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assembles")
public class AssemblesController {

    private final AssemblesService service;

    public AssemblesController(AssemblesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", AssemblesDto.empty());
        model.addAttribute("screen", "assembles");
        return "assembles";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "assembles");
        return "assembles";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") AssemblesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "assembles");
        model.addAttribute("saved", true);
        return "assembles";
    }
}
