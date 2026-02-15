package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.MergeContractorsDto;
import net.sam.dcl.modern.service.MergeContractorsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/merge-contractors")
public class MergeContractorsController {

    private final MergeContractorsService service;

    public MergeContractorsController(MergeContractorsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", MergeContractorsDto.empty());
        model.addAttribute("screen", "merge-contractors");
        return "merge-contractors";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "merge-contractors");
        return "merge-contractors";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") MergeContractorsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "merge-contractors");
        model.addAttribute("saved", true);
        return "merge-contractors";
    }
}
