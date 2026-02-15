package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.EquipmentListDto;
import net.sam.dcl.modern.service.EquipmentListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipment-list")
public class EquipmentListController {

    private final EquipmentListService service;

    public EquipmentListController(EquipmentListService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", EquipmentListDto.empty());
        model.addAttribute("screen", "equipment-list");
        return "equipment-list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "equipment-list");
        return "equipment-list";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") EquipmentListDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "equipment-list");
        model.addAttribute("saved", true);
        return "equipment-list";
    }
}
