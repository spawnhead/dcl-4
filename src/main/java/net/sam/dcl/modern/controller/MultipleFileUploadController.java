package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.MultipleFileUploadDto;
import net.sam.dcl.modern.service.MultipleFileUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/multiple-file-upload")
public class MultipleFileUploadController {

    private final MultipleFileUploadService service;

    public MultipleFileUploadController(MultipleFileUploadService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", MultipleFileUploadDto.empty());
        model.addAttribute("screen", "multiple-file-upload");
        return "multiple-file-upload";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "multiple-file-upload");
        return "multiple-file-upload";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") MultipleFileUploadDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "multiple-file-upload");
        model.addAttribute("saved", true);
        return "multiple-file-upload";
    }
}
