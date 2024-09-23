package com.complexivo.gestion.controller;

import com.complexivo.gestion.model.Matricula;
import com.complexivo.gestion.service.CursoService;
import com.complexivo.gestion.service.EstudianteService;
import com.complexivo.gestion.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;
    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listMatriculas(Model model) {
        model.addAttribute("matriculas", matriculaService.findAll());
        return "matriculas/lista";
    }

    @GetMapping("/crear")
    public String createMatriculaForm(Model model) {
        model.addAttribute("matricula", new Matricula()); // Crear una nueva matrícula
        model.addAttribute("estudiantes", estudianteService.findAll()); // Lista de estudiantes
        model.addAttribute("cursos", cursoService.findAll()); // Lista de cursos
        return "matriculas/crear";
    }

    @PostMapping("/guardar")
    public String saveMatricula(@ModelAttribute Matricula matricula) {
        matriculaService.saveMatricula(matricula);
        return "redirect:/matriculas";
    }

    @GetMapping("/editar/{id}")
    public String editMatriculaForm(@PathVariable Long id, Model model) {
        model.addAttribute("matricula", matriculaService.findById(id));
        return "matriculas/crear";
    }

    @PostMapping("/editar/{id}")
    public String updateMatricula(@PathVariable Long id, @ModelAttribute Matricula matricula) {
        matricula.setIdMatricula(id);
        matriculaService.saveMatricula(matricula);
        return "redirect:/matriculas";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteMatricula(@PathVariable Long id) {
        matriculaService.deleteMatricula(id);
        return "redirect:/matriculas";
    }
}
