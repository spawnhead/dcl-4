package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ActionDto;
import net.sam.dcl.modern.service.ActionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/action")
public class ActionController {

    private final ActionService service;

    public ActionController(ActionService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ActionDto.empty());
        model.addAttribute("screen", "action");
        return "action";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "action");
        return "action";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ActionDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "action");
        model.addAttribute("saved", true);
        return "action";
    }
}
