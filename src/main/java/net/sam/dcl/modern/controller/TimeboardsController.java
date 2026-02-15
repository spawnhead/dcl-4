package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.TimeboardsDto;
import net.sam.dcl.modern.service.TimeboardsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeboards")
public class TimeboardsController {

    private final TimeboardsService service;

    public TimeboardsController(TimeboardsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", TimeboardsDto.empty());
        model.addAttribute("screen", "timeboards");
        return "timeboards";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "timeboards");
        return "timeboards";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") TimeboardsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "timeboards");
        model.addAttribute("saved", true);
        return "timeboards";
    }
}
