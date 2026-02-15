package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.SerialNumberListDto;
import net.sam.dcl.modern.service.SerialNumberListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/serial-number-list")
public class SerialNumberListController {

    private final SerialNumberListService service;

    public SerialNumberListController(SerialNumberListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", SerialNumberListDto.empty());
        model.addAttribute("screen", "serial-number-list");
        return "serial-number-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "serial-number-list");
        return "serial-number-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") SerialNumberListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "serial-number-list");
        model.addAttribute("saved", true);
        return "serial-number-list";
    }
}
