package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.LockedRecordsOldDto;
import net.sam.dcl.modern.service.LockedRecordsOldService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locked-records.old")
public class LockedRecordsOldController {

    private final LockedRecordsOldService service;

    public LockedRecordsOldController(LockedRecordsOldService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", LockedRecordsOldDto.empty());
        model.addAttribute("screen", "locked-records.old");
        return "locked-records.old";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "locked-records.old");
        return "locked-records.old";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") LockedRecordsOldDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "locked-records.old");
        model.addAttribute("saved", true);
        return "locked-records.old";
    }
}
