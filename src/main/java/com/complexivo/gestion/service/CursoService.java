package com.complexivo.gestion.service;

import com.complexivo.gestion.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> findAll();
    Curso saveCurso(Curso curso);
    Curso findById(Long id);
    void deleteCurso(Long id);
}
