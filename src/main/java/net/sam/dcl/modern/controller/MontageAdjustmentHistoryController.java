package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.MontageAdjustmentHistoryDto;
import net.sam.dcl.modern.service.MontageAdjustmentHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/montage-adjustment-history")
public class MontageAdjustmentHistoryController {

    private final MontageAdjustmentHistoryService service;

    public MontageAdjustmentHistoryController(MontageAdjustmentHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", MontageAdjustmentHistoryDto.empty());
        model.addAttribute("screen", "montage-adjustment-history");
        return "montage-adjustment-history";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "montage-adjustment-history");
        return "montage-adjustment-history";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") MontageAdjustmentHistoryDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "montage-adjustment-history");
        model.addAttribute("saved", true);
        return "montage-adjustment-history";
    }
}
