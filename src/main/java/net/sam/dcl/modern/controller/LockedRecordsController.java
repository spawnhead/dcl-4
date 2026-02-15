package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.LockedRecordsDto;
import net.sam.dcl.modern.service.LockedRecordsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locked-records")
public class LockedRecordsController {

    private final LockedRecordsService service;

    public LockedRecordsController(LockedRecordsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", LockedRecordsDto.empty());
        model.addAttribute("screen", "locked-records");
        return "locked-records";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "locked-records");
        return "locked-records";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") LockedRecordsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "locked-records");
        model.addAttribute("saved", true);
        return "locked-records";
    }
}
