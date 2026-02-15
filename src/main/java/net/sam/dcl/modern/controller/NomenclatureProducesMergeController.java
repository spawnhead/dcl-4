package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.NomenclatureProducesMergeDto;
import net.sam.dcl.modern.service.NomenclatureProducesMergeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nomenclature-produces-merge")
public class NomenclatureProducesMergeController {

    private final NomenclatureProducesMergeService service;

    public NomenclatureProducesMergeController(NomenclatureProducesMergeService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", NomenclatureProducesMergeDto.empty());
        model.addAttribute("screen", "nomenclature-produces-merge");
        return "nomenclature-produces-merge";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "nomenclature-produces-merge");
        return "nomenclature-produces-merge";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") NomenclatureProducesMergeDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "nomenclature-produces-merge");
        model.addAttribute("saved", true);
        return "nomenclature-produces-merge";
    }
}
