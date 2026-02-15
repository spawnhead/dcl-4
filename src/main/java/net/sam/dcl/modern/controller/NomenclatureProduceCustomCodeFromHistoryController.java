package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.NomenclatureProduceCustomCodeFromHistoryDto;
import net.sam.dcl.modern.service.NomenclatureProduceCustomCodeFromHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nomenclature-produce-custom-code-from-history")
public class NomenclatureProduceCustomCodeFromHistoryController {

    private final NomenclatureProduceCustomCodeFromHistoryService service;

    public NomenclatureProduceCustomCodeFromHistoryController(NomenclatureProduceCustomCodeFromHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", NomenclatureProduceCustomCodeFromHistoryDto.empty());
        model.addAttribute("screen", "nomenclature-produce-custom-code-from-history");
        return "nomenclature-produce-custom-code-from-history";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "nomenclature-produce-custom-code-from-history");
        return "nomenclature-produce-custom-code-from-history";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") NomenclatureProduceCustomCodeFromHistoryDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "nomenclature-produce-custom-code-from-history");
        model.addAttribute("saved", true);
        return "nomenclature-produce-custom-code-from-history";
    }
}
