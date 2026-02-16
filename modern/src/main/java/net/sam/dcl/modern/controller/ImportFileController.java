package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ImportFileDto;
import net.sam.dcl.modern.service.ImportFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/import-file")
public class ImportFileController {

    private final ImportFileService service;

    public ImportFileController(ImportFileService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ImportFileDto.empty());
        model.addAttribute("screen", "import-file");
        return "import-file";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "import-file");
        return "import-file";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ImportFileDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "import-file");
        model.addAttribute("saved", true);
        return "import-file";
    }
}
