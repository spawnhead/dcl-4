package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.MontageAdjustmentsDto;
import net.sam.dcl.modern.service.MontageAdjustmentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/montage-adjustments")
public class MontageAdjustmentsController {

    private final MontageAdjustmentsService service;

    public MontageAdjustmentsController(MontageAdjustmentsService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", MontageAdjustmentsDto.empty());
        model.addAttribute("screen", "montage-adjustments");
        return "montage-adjustments";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "montage-adjustments");
        return "montage-adjustments";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") MontageAdjustmentsDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "montage-adjustments");
        model.addAttribute("saved", true);
        return "montage-adjustments";
    }
}
