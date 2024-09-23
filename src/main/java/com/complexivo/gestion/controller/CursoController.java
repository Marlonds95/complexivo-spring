package com.complexivo.gestion.controller;

import com.complexivo.gestion.model.Curso;
import com.complexivo.gestion.implementacionService.CursoServiceImpl;
import com.complexivo.gestion.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listCursos(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        return "cursos/lista";
    }

    @GetMapping("/crear")
    public String createCursoForm(Model model) {
        model.addAttribute("curso", new Curso());
        return "cursos/crear";
    }

    @PostMapping("/guardar")
    public String saveCurso(@ModelAttribute Curso curso) {
        cursoService.saveCurso(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String editCursoForm(@PathVariable Long id, Model model) {
        model.addAttribute("curso", cursoService.findById(id));
        return "cursos/crear";
    }

    @PostMapping("/editar/{id}")
    public String updateCurso(@PathVariable Long id, @ModelAttribute Curso curso) {
        curso.setIdCurso(id);
        cursoService.saveCurso(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
        return "redirect:/cursos";
    }
}

