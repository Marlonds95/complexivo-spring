package com.complexivo.gestion.controller;

import com.complexivo.gestion.model.Estudiante;
import com.complexivo.gestion.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public String listEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.findAll());
        return "estudiantes/lista";
    }

    @GetMapping("/crear")
    public String createEstudianteForm(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiantes/crear";
    }

    @PostMapping("/guardar")
    public String saveEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.saveEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editEstudianteForm(@PathVariable Long id, Model model) {
        model.addAttribute("estudiante", estudianteService.findById(id));
        return "estudiantes/crear";
    }

    @PostMapping("/editar/{id}")
    public String updateEstudiante(@PathVariable Long id, @ModelAttribute Estudiante estudiante) {
        estudiante.setIdEstudiante(id);
        estudianteService.saveEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteEstudiante(@PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
        return "redirect:/estudiantes";
    }
}


