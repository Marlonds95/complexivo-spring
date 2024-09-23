package com.complexivo.gestion.controller;

import com.complexivo.gestion.model.Aula;
import com.complexivo.gestion.implementacionService.AulaServiceImpl;
import com.complexivo.gestion.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping
    public String listAulas(Model model) {
        model.addAttribute("aulas", aulaService.findAll());
        return "aulas/lista";
    }

    @GetMapping("/crear")
    public String createAulaForm(Model model) {
        model.addAttribute("aula", new Aula());
        return "aulas/crear";
    }

    @PostMapping("/guardar")
    public String saveAula(@ModelAttribute Aula aula) {
        aulaService.saveAula(aula);
        return "redirect:/aulas";
    }

    @GetMapping("/editar/{id}")
    public String editAulaForm(@PathVariable Long id, Model model) {
        model.addAttribute("aula", aulaService.findById(id));
        return "aulas/crear";
    }

    @PostMapping("/editar/{id}")
    public String updateAula(@PathVariable Long id, @ModelAttribute Aula aula) {
        aula.setIdAula(id);
        aulaService.saveAula(aula);
        return "redirect:/aulas";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteAula(@PathVariable Long id) {
        aulaService.deleteAula(id);
        return "redirect:/aulas";
    }
}
