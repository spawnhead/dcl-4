package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ClosedRecordDto;
import net.sam.dcl.modern.service.ClosedRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/closed-record")
public class ClosedRecordController {

    private final ClosedRecordService service;

    public ClosedRecordController(ClosedRecordService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ClosedRecordDto.empty());
        model.addAttribute("screen", "closed-record");
        return "closed-record";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "closed-record");
        return "closed-record";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ClosedRecordDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "closed-record");
        model.addAttribute("saved", true);
        return "closed-record";
    }
}
