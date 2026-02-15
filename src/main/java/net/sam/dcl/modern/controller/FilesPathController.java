package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.FilesPathDto;
import net.sam.dcl.modern.service.FilesPathService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files-path")
public class FilesPathController {

    private final FilesPathService service;

    public FilesPathController(FilesPathService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", FilesPathDto.empty());
        model.addAttribute("screen", "files-path");
        return "files-path";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "files-path");
        return "files-path";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") FilesPathDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "files-path");
        model.addAttribute("saved", true);
        return "files-path";
    }
}
