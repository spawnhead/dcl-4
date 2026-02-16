package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.UploadFileDto;
import net.sam.dcl.modern.service.UploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload-file")
public class UploadFileController {

    private final UploadFileService service;

    public UploadFileController(UploadFileService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", UploadFileDto.empty());
        model.addAttribute("screen", "upload-file");
        return "upload-file";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "upload-file");
        return "upload-file";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") UploadFileDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "upload-file");
        model.addAttribute("saved", true);
        return "upload-file";
    }
}
