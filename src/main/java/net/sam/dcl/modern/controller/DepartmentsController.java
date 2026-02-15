package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.DepartmentsDto;
import net.sam.dcl.modern.service.DepartmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentsService service;

    public DepartmentsController(DepartmentsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", DepartmentsDto.empty());
        model.addAttribute("screen", "departments");
        return "departments";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "departments");
        return "departments";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") DepartmentsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "departments");
        model.addAttribute("saved", true);
        return "departments";
    }
}
