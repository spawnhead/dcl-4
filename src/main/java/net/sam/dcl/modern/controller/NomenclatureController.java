package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.NomenclatureDto;
import net.sam.dcl.modern.service.NomenclatureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nomenclature")
public class NomenclatureController {

    private final NomenclatureService service;

    public NomenclatureController(NomenclatureService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", NomenclatureDto.empty());
        model.addAttribute("screen", "nomenclature");
        return "nomenclature";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "nomenclature");
        return "nomenclature";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") NomenclatureDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "nomenclature");
        model.addAttribute("saved", true);
        return "nomenclature";
    }
}
