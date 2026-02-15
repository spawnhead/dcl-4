package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.ContractClosedDto;
import net.sam.dcl.modern.service.ContractClosedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract-closed")
public class ContractClosedController {

    private final ContractClosedService service;

    public ContractClosedController(ContractClosedService service) {
        this.service = service;
    }

    @GetMapping
    public String input(Model model) {
        model.addAttribute("dto", ContractClosedDto.empty());
        model.addAttribute("screen", "contract-closed");
        return "contract-closed";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("dto", service.load(id));
        model.addAttribute("screen", "contract-closed");
        return "contract-closed";
    }

    @PostMapping
    public String process(@ModelAttribute("dto") ContractClosedDto dto, Model model) {
        model.addAttribute("dto", service.process(dto));
        model.addAttribute("screen", "contract-closed");
        model.addAttribute("saved", true);
        return "contract-closed";
    }
}
