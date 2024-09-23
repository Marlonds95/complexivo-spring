package com.complexivo.gestion.service;

import com.complexivo.gestion.model.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    List<Estudiante> findAll();
    Estudiante saveEstudiante(Estudiante estudiante);
    Estudiante findById(Long id);
    void deleteEstudiante(Long id);
}

