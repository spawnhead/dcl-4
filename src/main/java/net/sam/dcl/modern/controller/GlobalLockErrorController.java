package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.GlobalLockErrorDto;
import net.sam.dcl.modern.service.GlobalLockErrorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/global-lock-error")
public class GlobalLockErrorController {

    private final GlobalLockErrorService service;

    public GlobalLockErrorController(GlobalLockErrorService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", GlobalLockErrorDto.empty());
        model.addAttribute("screen", "global-lock-error");
        return "global-lock-error";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "global-lock-error");
        return "global-lock-error";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") GlobalLockErrorDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "global-lock-error");
        model.addAttribute("saved", true);
        return "global-lock-error";
    }
}
