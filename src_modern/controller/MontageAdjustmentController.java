package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.MontageAdjustmentDto;
import net.sam.dcl.modern.service.MontageAdjustmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/montage-adjustment")
public class MontageAdjustmentController {

    private final MontageAdjustmentService service;

    public MontageAdjustmentController(MontageAdjustmentService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", MontageAdjustmentDto.empty());
        model.addAttribute("screen", "montage-adjustment");
        return "montage-adjustment";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "montage-adjustment");
        return "montage-adjustment";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") MontageAdjustmentDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "montage-adjustment");
        model.addAttribute("saved", true);
        return "montage-adjustment";
    }
}
