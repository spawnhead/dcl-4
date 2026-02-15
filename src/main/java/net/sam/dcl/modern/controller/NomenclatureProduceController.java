package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.NomenclatureProduceDto;
import net.sam.dcl.modern.service.NomenclatureProduceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nomenclature-produce")
public class NomenclatureProduceController {

    private final NomenclatureProduceService service;

    public NomenclatureProduceController(NomenclatureProduceService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", NomenclatureProduceDto.empty());
        model.addAttribute("screen", "nomenclature-produce");
        return "nomenclature-produce";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "nomenclature-produce");
        return "nomenclature-produce";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") NomenclatureProduceDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "nomenclature-produce");
        model.addAttribute("saved", true);
        return "nomenclature-produce";
    }
}
