package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.WoodworkWorkFilesDto;
import net.sam.dcl.modern.service.WoodworkWorkFilesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/woodwork-work-files")
public class WoodworkWorkFilesController {

    private final WoodworkWorkFilesService service;

    public WoodworkWorkFilesController(WoodworkWorkFilesService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", WoodworkWorkFilesDto.empty());
        model.addAttribute("screen", "woodwork-work-files");
        return "woodwork-work-files";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "woodwork-work-files");
        return "woodwork-work-files";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") WoodworkWorkFilesDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "woodwork-work-files");
        model.addAttribute("saved", true);
        return "woodwork-work-files";
    }
}
