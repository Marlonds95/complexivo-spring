package com.complexivo.gestion.controller;

import com.complexivo.gestion.model.Docente;
import com.complexivo.gestion.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public String listDocentes(Model model) {
        model.addAttribute("docentes", docenteService.findAll());
        return "docentes/lista";
    }

    @GetMapping("/crear")
    public String createDocenteForm(Model model) {
        model.addAttribute("docente", new Docente());
        return "docentes/crear";
    }

    @PostMapping("/guardar")
    public String saveDocente(@ModelAttribute Docente docente) {
        docenteService.saveDocente(docente);
        return "redirect:/docentes";
    }

    @GetMapping("/editar/{id}")
    public String editDocenteForm(@PathVariable Long id, Model model) {
        model.addAttribute("docente", docenteService.findById(id));
        return "docentes/crear";
    }

    @PostMapping("/editar/{id}")
    public String updateDocente(@PathVariable Long id, @ModelAttribute Docente docente) {
        docente.setIdDocente(id);
        docenteService.saveDocente(docente);
        return "redirect:/docentes";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteDocente(@PathVariable Long id) {
        docenteService.deleteDocente(id);
        return "redirect:/docentes";
    }
}


