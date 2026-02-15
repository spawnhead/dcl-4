package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.DepartmentDto;
import net.sam.dcl.modern.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", DepartmentDto.empty());
        model.addAttribute("screen", "department");
        return "department";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "department");
        return "department";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") DepartmentDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "department");
        model.addAttribute("saved", true);
        return "department";
    }
}
