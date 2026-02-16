package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.FilesPathsDto;
import net.sam.dcl.modern.service.FilesPathsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files-paths")
public class FilesPathsController {

    private final FilesPathsService service;

    public FilesPathsController(FilesPathsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", FilesPathsDto.empty());
        model.addAttribute("screen", "files-paths");
        return "files-paths";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "files-paths");
        return "files-paths";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") FilesPathsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "files-paths");
        model.addAttribute("saved", true);
        return "files-paths";
    }
}
