package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.DeferredUploadFileDto;
import net.sam.dcl.modern.service.DeferredUploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deferred-upload-file")
public class DeferredUploadFileController {

    private final DeferredUploadFileService service;

    public DeferredUploadFileController(DeferredUploadFileService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", DeferredUploadFileDto.empty());
        model.addAttribute("screen", "deferred-upload-file");
        return "deferred-upload-file";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "deferred-upload-file");
        return "deferred-upload-file";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") DeferredUploadFileDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "deferred-upload-file");
        model.addAttribute("saved", true);
        return "deferred-upload-file";
    }
}
