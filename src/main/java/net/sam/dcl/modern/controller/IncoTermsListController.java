package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.IncoTermsListDto;
import net.sam.dcl.modern.service.IncoTermsListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inco-terms-list")
public class IncoTermsListController {

    private final IncoTermsListService service;

    public IncoTermsListController(IncoTermsListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", IncoTermsListDto.empty());
        model.addAttribute("screen", "inco-terms-list");
        return "inco-terms-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "inco-terms-list");
        return "inco-terms-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") IncoTermsListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "inco-terms-list");
        model.addAttribute("saved", true);
        return "inco-terms-list";
    }
}
