package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.MontageAdjustmentsHistoryDto;
import net.sam.dcl.modern.service.MontageAdjustmentsHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/montage-adjustments-history")
public class MontageAdjustmentsHistoryController {

    private final MontageAdjustmentsHistoryService service;

    public MontageAdjustmentsHistoryController(MontageAdjustmentsHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", MontageAdjustmentsHistoryDto.empty());
        model.addAttribute("screen", "montage-adjustments-history");
        return "montage-adjustments-history";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "montage-adjustments-history");
        return "montage-adjustments-history";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") MontageAdjustmentsHistoryDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "montage-adjustments-history");
        model.addAttribute("saved", true);
        return "montage-adjustments-history";
    }
}
