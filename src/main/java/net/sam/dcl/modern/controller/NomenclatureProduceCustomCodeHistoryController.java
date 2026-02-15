package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.NomenclatureProduceCustomCodeHistoryDto;
import net.sam.dcl.modern.service.NomenclatureProduceCustomCodeHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nomenclature-produce-custom-code-history")
public class NomenclatureProduceCustomCodeHistoryController {

    private final NomenclatureProduceCustomCodeHistoryService service;

    public NomenclatureProduceCustomCodeHistoryController(NomenclatureProduceCustomCodeHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", NomenclatureProduceCustomCodeHistoryDto.empty());
        model.addAttribute("screen", "nomenclature-produce-custom-code-history");
        return "nomenclature-produce-custom-code-history";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "nomenclature-produce-custom-code-history");
        return "nomenclature-produce-custom-code-history";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") NomenclatureProduceCustomCodeHistoryDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "nomenclature-produce-custom-code-history");
        model.addAttribute("saved", true);
        return "nomenclature-produce-custom-code-history";
    }
}
